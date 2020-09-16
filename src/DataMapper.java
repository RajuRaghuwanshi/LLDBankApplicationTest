import java.util.HashMap;
import java.util.Map;

public class DataMapper {

    private volatile static DataMapper dataMapper;

    private Map<Integer, Branch> branchIdMapping;
    private Map<String, Customer> panCardCustomerMapping;
    private Map<Integer, Transaction> transactionIDMap;
    private Map<String, BankAccount> acctNoAccountMapping;

    private DataMapper() {
        this.branchIdMapping = new HashMap<>();
        this.transactionIDMap = new HashMap<>();
        this.panCardCustomerMapping = new HashMap<>();
        this.acctNoAccountMapping = new HashMap<>();
    }

    public static DataMapper getInstance() {
        if (dataMapper == null) {
            synchronized (DataMapper.class) {
                if (dataMapper == null) {
                    dataMapper = new DataMapper();
                }
            }
        }
        return dataMapper;
    }

    public Map<String, BankAccount> getAcctNoAccountMapping() {
        return acctNoAccountMapping;
    }

    public Map<Integer, Transaction> getTransactionIDMap() {
        return transactionIDMap;
    }

    public Map<String, Customer> getPanCardCustomerMapping() {
        return panCardCustomerMapping;
    }

    public Map<Integer, Branch> getBranchIdMapping() {
        return branchIdMapping;
    }
}
