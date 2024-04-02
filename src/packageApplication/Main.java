package packageApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import packageExeptions.DomainException;
import packageReservation.Reservation;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("ROOM NUMBER");
            int number = leitor.nextInt();
            System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
            Date checkin = sdf.parse(leitor.next());
            System.out.println("CHECK-OUT DATE (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(leitor.next());

            Reservation reservation = new Reservation(number, checkin, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("ENTER DATA TO UPDATE THE RESERVATION: ");
            System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
            checkin = sdf.parse(leitor.next());
            System.out.print("CHECK-OUT DATE (dd/MM/yyyy): ");
            checkOut = sdf.parse(leitor.next());

            reservation.updateDates(checkin, checkOut);
            System.out.println("RESERVATION: " + reservation);

        } catch (ParseException e) {
            System.out.println("INVALID DATE FORMAT");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("UNEXPECTED ERROR");
        }

        leitor.close();
    }
}
