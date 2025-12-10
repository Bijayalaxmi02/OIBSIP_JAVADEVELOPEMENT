import java.util.ArrayList;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private final ArrayList<String> transactionHistory;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public User() {
    }

    public boolean validateLogin(String enteredId, String enteredPin) {
        return enteredId.equals(userId) && enteredPin.equals(pin);
    }

    public void addTransaction(String message) {
        transactionHistory.add(message);
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        addTransaction("Withdrawn: ₹" + amount);
        return true;
    }

    public boolean transfer(double amount, User receiver) {
        if (amount > balance) return false;
        balance -= amount;
        receiver.balance += amount;
        addTransaction("Transferred: ₹" + amount + " to " + receiver.userId);
        return true;
    }
}