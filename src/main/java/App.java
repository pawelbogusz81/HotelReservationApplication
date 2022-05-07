import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 2;
        boolean isDeveloperVersion = true;

        showSystemInfo(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);

        int option = getActionFromUser(input);

        if (option == 1) {
            System.out.println("Tworzenie nowego gościa...");

            Guest newGuest = createNewGuest(input);

        } else if (option == 2) {
            System.out.println("Tworzenie nowego pokoju...");

            Room newRoom = createNewRoom(input);


        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Wybrano niepoprawną akcję.");
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

        int actionNumber= 0;

        try {
            actionNumber = in.nextInt();
        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejsciowe, wprowadz liczbę.");
            e.printStackTrace();
        }
        return actionNumber;
    }

    private static Guest createNewGuest(Scanner input) {

        try {
            System.out.print("Podaj swoje imię: ");
            String firstName = input.next();
            System.out.print("Podaj swoje nazwisko: ");
            String lastName = input.next();
            System.out.print("Podaj swój wiek: ");
            int age = input.nextInt();

            Gender gender = getGenderFromUser(input);
            Guest newGuest = new Guest(firstName, lastName, age, gender);
            System.out.println(newGuest.getInfo());

            return newGuest;
        } catch (Exception e) {
            System.out.println("Podaj wiek jako liczbę!");
            e.printStackTrace();
            return null;
        }
    }

    private static Room createNewRoom(Scanner in) {

        try {
            System.out.print("Podaj numer pokoju: ");
            int number = in.nextInt();

            BedType bedType[] = chooseBedType(in);
            Room newRoom = new Room(number, bedType);
            System.out.println(newRoom.getInfo());

            return newRoom;
        } catch (Exception e) {
            System.out.println("Podane dane muszą być liczbami!");
            e.printStackTrace();
            return null;
        }
    }

    private static BedType[] chooseBedType(Scanner in) {

        System.out.print("Ile łóżek w pokoju? ");
        int bedNumber = in.nextInt();
        BedType[] bedTypes = new BedType[bedNumber];

        for (int i=0; i<bedNumber; i++) {
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
                System.out.println("Dostepne opcje to wyłącznie 1,2 lub 3");
            }

            bedTypes[i] = bedType;
        }

        return bedTypes;
    }

    private static Gender getGenderFromUser(Scanner input) {

        System.out.println("Podaj swoją płeć: ");
        System.out.println("\t1. Kobieta (FEMALE)");
        System.out.println("\t2. Mężczyzna (MALE)");
        System.out.print("Twoja płeć to: ");

        int genderOption = input.nextInt();
        Gender gender = null;
        if (genderOption == 1) {
            gender = Gender.FEMALE;
        } else if (genderOption == 2) {
            gender = Gender.MALE;
        } else {
            System.out.println("Dostepne opcje to wyłącznie 1,2");
        }
        return gender;
    }

}
