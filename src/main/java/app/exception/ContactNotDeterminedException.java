package app.exception;

public class ContactNotDeterminedException extends RuntimeException{
    public ContactNotDeterminedException() {
    }

    public ContactNotDeterminedException(String message) {
        super(message);
    }

    public ContactNotDeterminedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactNotDeterminedException(Throwable cause) {
        super(cause);
    }

    public ContactNotDeterminedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

