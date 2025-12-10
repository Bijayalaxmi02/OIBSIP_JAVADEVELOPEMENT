import java.util.Scanner;

public class ATM {
    private User user;
    private Scanner sc;

    public ATM(User user) {
        this.user = user;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n===== Welcome to ATM =====");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> showTransactionHistory();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> {
                    System.out.println("\nThank you for using ATM. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    private void showTransactionHistory() {
        System.out.println("\n----- Transaction History -----");
        if (user.getTransactionHistory().isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            for (String t : user.getTransactionHistory()) {
                System.out.println(t);
            }
        }
        System.out.println("------------------------------");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (user.withdraw(amount)) {
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        user.deposit(amount);
        System.out.println("Deposit Successful!");
    }

    private void transfer() {
        System.out.print("Enter receiver user ID: ");
        String receiverId = sc.next();
        System.out.print("Enter amount to transfer: ₹");
        double amount = sc.nextDouble();

        // For demo, create a new dummy user as receiver
        User receiver = new User(receiverId, "0000", 0);

        if (user.transfer(amount, receiver)) {
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
