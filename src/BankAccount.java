import java.util.*;

public abstract class BankAccount {

    private String accountNumber;
    private double minimumBalance;
    private double currentBalance;
    private double interestRate;
    private TreeSet<Transaction> transactions;
    private AccountType accountType;

    private DataMapper dataMapper = DataMapper.getInstance();

    //we can use Builder pattern here
    public BankAccount(String accountNumber, Double minimumBalance, Double currentBalance, Double interestRate, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
        this.transactions = new TreeSet<>();
        this.accountType = accountType;
        deposit(currentBalance);
    }

    void withdraw(Double amount) {

        if (amount <= 0) {
            throw new AmountValueCheckException(ErrorMessages.AMOUNT_CHECK);
        }

        if (amount > currentBalance || currentBalance - amount < minimumBalance) {
            throw new MinBalanceCheckException(ErrorMessages.MINBALANCE_CHECK);
        }

        int numberOfTransaction = this.transactions.size();
        int transactionId = numberOfTransaction + 1;

        Transaction transaction = new Transaction(transactionId, new Date(), amount, TransactionType.WITHDRAW);
        currentBalance -= amount;

        this.transactions.add(transaction);
    }

    void deposit(Double amount) {
        if (amount <= 0) {
            throw new AmountValueCheckException(ErrorMessages.AMOUNT_CHECK);
        }

        int numberOfTransaction = this.transactions.size();
        int transactionId = numberOfTransaction + 1;

        Transaction transaction = new Transaction(transactionId, new Date(), amount, TransactionType.DEPOSIT);
        currentBalance += amount;
        this.transactions.add(transaction);

    }

    Set<Transaction> getTransactionHistory() {
        return transactions;
    }

    Set<Transaction> getMiniStatement() {
        int numberOfTransaction = transactions.size();
        Map<Integer, Transaction> transactionIDMap = dataMapper.getTransactionIDMap();
        Transaction transaction = transactionIDMap.get(numberOfTransaction - ApplicationConstants.MAX_NUMBER_OF_TRANSACTIONS_IN_MISSTATEMENT);
        return transactions.tailSet(transaction);
    }

    double getMiniBalance() {
        double minBalance;
        if (AccountType.CURRENT == this.accountType) {
            minBalance = ApplicationConstants.CURRENT_ACCOUNT_MIN_BALANCE;
        } else {
            minBalance = ApplicationConstants.SAVING_ACCOUNT_MIN_BALANCE;
        }

        return minBalance;
    }

    boolean getCurrentBalance() {
        return false;
    }

    abstract double getInterestRate();

    abstract AccountType getType();

    @Override
    public String toString() {
        return "BankAccount{" +
                       "accountNumber='" + accountNumber + '\'' +
                       ", minimumBalance=" + minimumBalance +
                       ", currentBalance=" + currentBalance +
                       ", interestRate=" + interestRate +
                       ", transactions=" + transactions +
                       ", accountType=" + accountType +
                       '}';
    }
}
