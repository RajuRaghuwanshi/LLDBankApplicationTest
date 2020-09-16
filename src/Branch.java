import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Branch {

    private List<BankAccount> bankAccounts;
    private List<Customer> customers;
    private int branchId;

    public Branch(int branchId) {
        this.branchId = branchId;
        this.bankAccounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    BankAccount createBankAccount(String panNumber, AccountType type, Double amount) {

        BankAccountFactory bankAccountFactory;

        if (type == AccountType.SAVING) {
            bankAccountFactory = new CreateSavingBankAccount();
        } else {
            bankAccountFactory = new CreateCurrentBankAccount();
        }


        BankAccount bankAccount = bankAccountFactory.createBankAccount(panNumber, amount);
        this.bankAccounts.add(bankAccount);

        DataMapper dataMapper = DataMapper.getInstance();
        this.customers.add(dataMapper.getPanCardCustomerMapping().get(panNumber));
        return bankAccount;
    }

    Customer getCustomerByPanNumber(String panNumber) {

        DataMapper dataMapper = DataMapper.getInstance();

        Map<String, Customer> panCardCustomerMapping = dataMapper.getPanCardCustomerMapping();
        Customer customer = panCardCustomerMapping.get(panNumber);

        if (customer == null) {
            throw new DataNotFoundException(ErrorMessages.DATA_NOT_FOUND);
        }

        return customer;
    }

    BankAccount getAccountByAccountNumber(String accountNumber) {
        DataMapper dataMapper = DataMapper.getInstance();

        Map<String, BankAccount> acctNoAccountMapping = dataMapper.getAcctNoAccountMapping();
        BankAccount bankAccount = acctNoAccountMapping.get(accountNumber);

        if (bankAccount == null) {
            throw new DataNotFoundException(ErrorMessages.DATA_NOT_FOUND);
        }

        return bankAccount;
    }

    @Override
    public String toString() {
        return "Branch{" +
                       "bankAccounts=" + bankAccounts +
                       ", customers=" + customers +
                       ", branchId=" + branchId +
                       '}';
    }
}
