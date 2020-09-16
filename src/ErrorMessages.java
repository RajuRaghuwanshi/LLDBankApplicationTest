public enum ErrorMessages {

    AMOUNT_CHECK("Amount should be greater than 0"),
    MINBALANCE_CHECK("Minimum balance constraint failed"),
    DATA_NOT_FOUND("Data not found");

    private String action;

    public String getAction() {
        return this.action;
    }

    ErrorMessages(String action) {
        this.action = action;
    }
    }
