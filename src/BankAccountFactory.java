import java.util.Map;

public interface BankAccountFactory {

    BankAccount createBankAccount(String panNumber, Double amount);
}
