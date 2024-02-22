package app.exception;

public class ContactNotValidException extends RuntimeException{
    public ContactNotValidException() {
    }

    public ContactNotValidException(String message) {
        super(message);
    }

    public ContactNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactNotValidException(Throwable cause) {
        super(cause);
    }

    public ContactNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
