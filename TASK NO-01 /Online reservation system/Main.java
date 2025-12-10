import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        
        Database.users.add(new User("admin", "1234"));

        System.out.println("===== ONLINE RESERVATION SYSTEM =====\n");

        if (login()) {
            menu();
        } else {
            System.out.println("Invalid Login. Exiting!");
        }
    }


    public static boolean login() {
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (User user : Database.users) {
            if (user.userId.equals(id) && user.password.equals(pass)) {
                System.out.println("\nLogin Successful!\n");
                return true;
            }
        }
        return false;
    }

    public static void menu() {
        while (true) {
            System.out.println("1. Reservation");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Ticket (PNR Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> reservationForm();
                case 2 -> cancelTicket();
                case 3 -> viewTicket();
                case 4 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    public static void reservationForm() {
        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Train Name: ");
        String train = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("Destination: ");
        String destination = sc.nextLine();

        System.out.print("Class Type (Sleeper/AC/General): ");
        String classType = sc.nextLine();

        System.out.print("Journey Date: ");
        String date = sc.nextLine();

        Reservation r = new Reservation(name, train, from, destination, classType, date);
        Database.reservations.add(r);

        System.out.println("\nBooking Successful! Your PNR Number: " + r.pnr);
    }

    public static void cancelTicket() {
        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        if (Cancellation.cancelTicket(pnr)) {
            System.out.println("Ticket Cancelled Successfully!");
        } else {
            System.out.println("PNR Not Found!");
        }
    }

    public static void viewTicket() {
        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        for (Reservation r : Database.reservations) {
            if (r.pnr == pnr) {
                r.display();
                return;
            }
        }
        System.out.println("Ticket Not Found!");
    }
}