package auth.services;

import auth.daos.PasswordRestoreTokenDao;
import auth.exceptions.InvalidRestoreTokenException;
import auth.models.PasswordRestoreToken;
import common.utils.KeyHasher;
import users.daos.UserDao;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class PasswordRestoreService {
    private final PasswordRestoreTokenDao passwordRestoreTokenDao;
    private final UserDao userDao;

    public PasswordRestoreService(PasswordRestoreTokenDao passwordRestoreTokenDao, UserDao userDao) {
        this.passwordRestoreTokenDao = passwordRestoreTokenDao;
        this.userDao = userDao;
    }

    public void restorePassword(String rawToken, String newPassword) throws NoSuchAlgorithmException {
        String tokenHash = KeyHasher.sha256(rawToken);
        PasswordRestoreToken token = passwordRestoreTokenDao.findByToken(tokenHash)
                .orElseThrow(() -> new InvalidRestoreTokenException("The token is invalid"));

        if (token.isUsed()) {
            throw new InvalidRestoreTokenException("The token has already been used");
        }

        if (!token.expiresAt().isAfter(LocalDateTime.now())) {
            throw new InvalidRestoreTokenException("The token has expired");
        }

        if (!userDao.restorePassword(token.userId(), newPassword, token.id())) {
            throw new IllegalStateException("Password restoration failed");
        }
    }
}
