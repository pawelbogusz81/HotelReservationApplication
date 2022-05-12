import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {

    GuestService guestService = new GuestService();
    RoomService roomService = new RoomService();

    public void readNewGuestData(Scanner input) {

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

            if (genderOption != 1 && genderOption != 2) {
                throw new WrongOptionException("Wrong option in gender menu.");
            }

            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, genderOption);
            System.out.println(newGuest.getInfo());

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing your age");
        }
    }

    public void readNewRoomData(Scanner input) {

        try {
            System.out.print("Podaj numer pokoju: ");
            int number = input.nextInt();
            int[] bedTypes = chooseBedType(input);
            Room newRoom = roomService.createNewRoom(number, bedTypes);
            System.out.println(newRoom.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing room number or number of beds");
        }
    }

    private static int[] chooseBedType(Scanner input) {
        System.out.print("Ile łóżek w pokoju?: ");
        int bedNumber = input.nextInt();

        int[] bedTypes = new int [bedNumber];


        for (int i = 0; i < bedNumber; i++) {
            System.out.println("Dostępne łóżka: ");
            System.out.println("\t1. Łóżko pojedyńcze (SINGLE)");
            System.out.println("\t2. Łóżko podwójne (DOUBLE)");
            System.out.println("\t3. Łoże królewskie (KING_SIZE)");
            System.out.print("Wybierz opcję: ");
            int bedTypeOption = input.nextInt();

            bedTypes[i] = bedTypeOption;
        }
        return bedTypes;

    }
}
