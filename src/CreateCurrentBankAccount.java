import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class CreateCurrentBankAccount implements BankAccountFactory {

    DataMapper dataMapper = DataMapper.getInstance();

    @Override
    public BankAccount createBankAccount(String panNumber, Double amount) {

        if (amount < ApplicationConstants.CURRENT_ACCOUNT_MIN_BALANCE) {
            throw new AmountValueCheckException(ErrorMessages.AMOUNT_CHECK);
        }

        Map<String, Customer> panCardCustomerMapping = dataMapper.getPanCardCustomerMapping();
        Map<String, BankAccount> acctNoAccountMapping = dataMapper.getAcctNoAccountMapping();
        Customer customer = panCardCustomerMapping.getOrDefault(panNumber, new Customer(panNumber));

        String accountNumber = UUID.randomUUID().toString();

        BankAccount currentBankAccount = new SavingAccount(accountNumber, ApplicationConstants.CURRENT_ACCOUNT_MIN_BALANCE, amount, ApplicationConstants.CURRENT_ACCOUNT_INTEREST_RATE, AccountType.CURRENT);



        customer.getAccounts().add(currentBankAccount);

        panCardCustomerMapping.put(panNumber, customer);
        acctNoAccountMapping.put(accountNumber, currentBankAccount);

        return currentBankAccount;
    }
}
