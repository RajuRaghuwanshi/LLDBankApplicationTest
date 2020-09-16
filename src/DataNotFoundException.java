public class DataNotFoundException extends RuntimeException {
    private ErrorMessages error;

    public DataNotFoundException(ErrorMessages error) {
        this.error = error;
    }

    public DataNotFoundException(String message, ErrorMessages error) {
        super(message);
        this.error = error;
    }

    public DataNotFoundException(String message, Throwable cause, ErrorMessages error) {
        super(message, cause);
        this.error = error;
    }

    public DataNotFoundException(Throwable cause, ErrorMessages error) {
        super(cause);
        this.error = error;
    }

    public DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorMessages error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
