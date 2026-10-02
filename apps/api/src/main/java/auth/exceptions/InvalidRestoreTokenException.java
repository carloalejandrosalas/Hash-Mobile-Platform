package auth.exceptions;

public class InvalidRestoreTokenException extends RuntimeException {
    public InvalidRestoreTokenException(String message) {
        super(message);
    }
}
