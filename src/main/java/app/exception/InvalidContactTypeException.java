package app.exception;

public class InvalidContactTypeException extends RuntimeException{
    public InvalidContactTypeException() {
    }

    public InvalidContactTypeException(String message) {
        super(message);
    }

    public InvalidContactTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidContactTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidContactTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
