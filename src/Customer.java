import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<BankAccount> accounts;
    private String panNumber;

    public Customer(String panNumber) {
        this.panNumber = panNumber;
        this.accounts = new ArrayList<>();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                       "accounts=" + accounts +
                       ", panNumber='" + panNumber + '\'' +
                       '}';
    }
}
