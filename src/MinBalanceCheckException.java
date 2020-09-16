
public class MinBalanceCheckException extends RuntimeException {
    private ErrorMessages error;

    public MinBalanceCheckException(ErrorMessages error) {
        this.error = error;
    }

    public MinBalanceCheckException(String message, ErrorMessages error) {
        super(message);
        this.error = error;
    }

    public MinBalanceCheckException(String message, Throwable cause, ErrorMessages error) {
        super(message, cause);
        this.error = error;
    }

    public MinBalanceCheckException(Throwable cause, ErrorMessages error) {
        super(cause);
        this.error = error;
    }

    public MinBalanceCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorMessages error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
