public class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber, Double minimumBalance, Double currentBalance, Double interestRate, AccountType accountType) {
        super(accountNumber, minimumBalance, currentBalance, interestRate, accountType);
    }

    @Override
    double getInterestRate() {
        return ApplicationConstants.SAVING_ACCOUNT_INTEREST_RATE;
    }

    @Override
    AccountType getType() {
        return AccountType.SAVING;
    }
}
