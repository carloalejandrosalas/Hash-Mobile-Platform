package core.utils;

import io.javalin.http.NotImplementedResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyHasher {

    public static String sha256(String key) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(key.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new NotImplementedResponse("SHA-256 hashing is not supported on this platform.");
        }
    }
}