import java.util.*;

public class CreateSavingBankAccount implements BankAccountFactory {

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

        BankAccount savingBankAccount = new CurrentAccount(accountNumber, ApplicationConstants.SAVING_ACCOUNT_MIN_BALANCE, amount, ApplicationConstants.SAVING_ACCOUNT_INTEREST_RATE, AccountType.SAVING);

        customer.getAccounts().add(savingBankAccount);

        panCardCustomerMapping.put(panNumber, customer);
        acctNoAccountMapping.put(accountNumber, savingBankAccount);
        return savingBankAccount;
    }
}
