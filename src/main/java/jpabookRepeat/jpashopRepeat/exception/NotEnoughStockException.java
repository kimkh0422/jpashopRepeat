package jpabookRepeat.jpashopRepeat.exception;


public class NotEnoughStockException extends RuntimeException {

    protected NotEnoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException() {
        super();
    }
}
