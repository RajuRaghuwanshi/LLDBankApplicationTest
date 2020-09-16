
public class AmountValueCheckException extends RuntimeException {

    private ErrorMessages error;

    public AmountValueCheckException(ErrorMessages error) {
        this.error = error;
    }

    public AmountValueCheckException(String message, ErrorMessages error) {
        super(message);
        this.error = error;
    }

    public AmountValueCheckException(String message, Throwable cause, ErrorMessages error) {
        super(message, cause);
        this.error = error;
    }

    public AmountValueCheckException(Throwable cause, ErrorMessages error) {
        super(cause);
        this.error = error;
    }

    public AmountValueCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorMessages error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
