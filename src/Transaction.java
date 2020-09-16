import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
    private int transactionId;
    private Date creationTime;
    private Double amount;
    private TransactionType transactionType;

    public Transaction(int transactionId, Date creationTime, Double amount, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.creationTime = creationTime;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                       "transactionId=" + transactionId +
                       ", creationTime=" + creationTime +
                       ", amount=" + amount +
                       ", transactionType=" + transactionType +
                       '}';
    }


    @Override
    public int compareTo(Transaction o) {
        return o.transactionId - this.transactionId;
    }
}
