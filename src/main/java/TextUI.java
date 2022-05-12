import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {

    GuestService guestService = new GuestService();

    public void readeNewGuestData(Scanner input) {

        try {
            System.out.print("Podaj swoje imię: ");
            String firstName = input.next();
            System.out.print("Podaj swoje nazwisko: ");
            String lastName = input.next();
            System.out.print("Podaj swój wiek: ");
            int age = input.nextInt();

            System.out.println("Podaj swoją płeć: ");
            System.out.println("\t1. Kobieta (FEMALE)");
            System.out.println("\t2. Mężczyzna (MALE)");
            System.out.print("Twoja płeć to: ");

            int genderOption = input.nextInt();

            if (genderOption !=1 && genderOption!=2) {
                throw new WrongOptionException("Wrong option in gender menu.");
            }

            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, genderOption);
            System.out.println(newGuest.getInfo());

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing your age");
        }
    }
}
