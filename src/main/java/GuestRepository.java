import java.util.InputMismatchException;
import java.util.Scanner;

public class GuestRepository {

    public GuestRepository (){

    }

    public Guest createNewGuest(Scanner input) {

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
            Gender gender = Gender.MALE;
            if (genderOption == 1) {
                gender = Gender.FEMALE;
            } else if (genderOption == 2) {
                gender = Gender.MALE;
            } else {
                throw new WrongOptionException("Wrong option in gender menu.");
            }

            Guest newGuest = new Guest(firstName, lastName, age, gender);
            System.out.println(newGuest.getInfo());

            return newGuest;
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing your age");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
