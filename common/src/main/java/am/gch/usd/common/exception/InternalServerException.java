package am.gch.usd.common.exception;

/**
 * Created by garik on 2/21/16.
 */
public class InternalServerException extends RuntimeException {

    public InternalServerException() {}

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }
}
