import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a demo user
        User user = new User("user123", "1234", 5000);

        System.out.println("===== ATM Login =====");
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (user.validateLogin(enteredId, enteredPin)) {
            ATM atm = new ATM(user);
            atm.start();
        } else {
            System.out.println("❌ Invalid Credentials. Access Denied!");
        }

        sc.close();
    }
}
