import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 2;
        boolean isDeveloperVersion = true;

        showSystemInfo(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);

        try {
            performAction(input);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown Exception.");
            System.out.println("Unknown exception code.");
            System.out.println("Exception message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Wychodzę z aplikacji.");
        }


    }

    private static void performAction(Scanner input) {
        int option = getActionFromUser(input);


        if (option == 1) {
            System.out.println("Tworzenie nowego gościa...");
//            Guest newGuest = guestService.createNewGuest(input);
            textUI.readeNewGuestData(input);

        } else if (option == 2) {
            System.out.println("Tworzenie nowego pokoju...");
            Room newRoom = createNewRoom(input);

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            throw new WrongOptionException("Wrong option in main menu.");
        }
    }

    private static void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {

        System.out.print("Witam w systemie rezerwacji dla hotelu: " + hotelName);
        System.out.print("Aktualna wersja systemu: " + systemVersion);
        System.out.print("Wersja developerska: " + isDeveloperVersion);

        System.out.println("\n=========================\n");
    }

    private static int getActionFromUser(Scanner in) {

        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.print("Wybierz opcję: ");

        int actionNumber = 0;

        try {
            actionNumber = in.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu.");
        }
        return actionNumber;
    }



    private static Room createNewRoom(Scanner in) {

        try {
            System.out.print("Podaj numer pokoju: ");
            int number = in.nextInt();

            BedType bedType[] = chooseBedType(in);
            Room newRoom = new Room(number, bedType);
            System.out.println(newRoom.getInfo());
            return newRoom;
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Numbers only required, when selecting bed type");
        }
    }

    private static BedType[] chooseBedType(Scanner in) {

        System.out.print("Ile łóżek w pokoju?: ");

        try {
            int bedNumber = in.nextInt();
            BedType[] bedTypes = new BedType[bedNumber];

            for (int i = 0; i < bedNumber; i++) {
                System.out.println("Dostępne łóżka: ");
                System.out.println("\t1. Łóżko pojedyńcze (SINGLE)");
                System.out.println("\t2. Łóżko podwójne (DOUBLE)");
                System.out.println("\t3. Łoże królewskie (KING_SIZE)");
                System.out.print("Wybierz opcję: ");

                int bedTypeOption = in.nextInt();
                BedType bedType = null;
                if (bedTypeOption == 1) {
                    bedType = BedType.SINGLE;
                } else if (bedTypeOption == 2) {
                    bedType = BedType.DOUBLE;
                } else if (bedTypeOption == 3) {
                    bedType = BedType.KING_SIZE;
                } else {
                    throw new WrongOptionException("Wrong option in bed's type menu.");
                }
                bedTypes[i] = bedType;
            }

            return bedTypes;

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing number of beds");
        }


    }

    private static Gender getGenderFromUser(Scanner input) {

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
        return gender;
    }

}
