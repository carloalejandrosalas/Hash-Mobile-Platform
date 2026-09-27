package core.utils;
import com.password4j.Password;

public class AuthUtils {
    public static String hashPassword (String password) {
        return Password.hash(password).addRandomSalt(12).withScrypt().getResult();
    }

    public static boolean checkPassword (String password, String hash) {
        return Password.check(password, hash).withScrypt();
    }
}
