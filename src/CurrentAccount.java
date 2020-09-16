public class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, Double minimumBalance, Double currentBalance, Double interestRate, AccountType accountType) {
        super(accountNumber, minimumBalance, currentBalance, interestRate, accountType);
    }

    @Override
    double getInterestRate() {
        return ApplicationConstants.CURRENT_ACCOUNT_INTEREST_RATE;
    }

    @Override
    AccountType getType() {
        return AccountType.CURRENT;
    }

}
