package exception;

public class TelephoneNotFoundException extends RuntimeException {
    public TelephoneNotFoundException() {
    }

    public TelephoneNotFoundException(String message) {
        super(message);
    }

    public TelephoneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelephoneNotFoundException(Throwable cause) {
        super(cause);
    }

    public TelephoneNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

