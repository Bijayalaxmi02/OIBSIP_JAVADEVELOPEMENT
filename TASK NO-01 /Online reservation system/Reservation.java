import java.util.Random;

public class Reservation {

    String name;
    String train;
    String from;
    String destination;
    String classType;
    String date;
    int pnr;

    public Reservation(String name, String train, String from, String destination, String classType, String date) {
        this.name = name;
        this.train = train;
        this.from = from;
        this.destination = destination;
        this.classType = classType;
        this.date = date;

        Random rand = new Random();
        this.pnr = 100000 + rand.nextInt(900000);
    }

    public void display() {
        System.out.println("\n========== TICKET DETAILS ==========");
        System.out.println("PNR Number: " + pnr);
        System.out.println("Passenger Name: " + name);
        System.out.println("Train: " + train);
        System.out.println("From: " + from);
        System.out.println("Destination: " + destination);
        System.out.println("Class: " + classType);
        System.out.println("Journey Date: " + date);
        System.out.println("====================================\n");
    }
}
