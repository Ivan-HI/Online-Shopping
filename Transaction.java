// Transaction.java
public class Transaction {
    private int transactionId;
    private String details;
    private String date;

    public Transaction() {}

    public Transaction(int transactionId, String details, String date) {
        this.transactionId = transactionId;
        this.details = details;
        this.date = date;
    }

    // Getters and Setters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public void updateDetails() {
        System.out.println("Transaction details updated.");
    }

    @Override
    public String toString() {
        return "Transaction: " + details + " (" + date + ")";
    }
}
