public class Cancellation {

    public static boolean cancelTicket(int pnr) {

        for (Reservation reservation : Database.reservations) {
            if (reservation.pnr == pnr) {
                Database.reservations.remove(reservation);
                return true;
            }
        }
        return false;
    }
}
