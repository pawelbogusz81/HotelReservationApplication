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

    static void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {

        System.out.print("Witam w systemie rezerwacji dla hotelu: " + hotelName);
        System.out.print("Aktualna wersja systemu: " + systemVersion);
        System.out.print("Wersja developerska: " + isDeveloperVersion);

        System.out.println("\n=========================\n");
    }

    static int getActionFromUser(Scanner in) {

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

    static Guest createNewGuest(Scanner input) {

        try {
            System.out.print("Podaj swoje imię: ");
            String firstName = input.next();
            System.out.print("Podaj swoje nazwisko: ");
            String lastName = input.next();
            System.out.print("Podaj swój wiek: ");
            int age = input.nextInt();

            Guest newGuest = new Guest(firstName, lastName, age);
            String newGuestInfo = String.format("Utworzono nowego gościa: %s %s (%d)", newGuest.firstName, newGuest.lastName, newGuest.age);
            System.out.println(newGuestInfo);
            return newGuest;
        } catch (Exception e) {
            System.out.println("Podaj wiek jako liczbę!");
            e.printStackTrace();
            return null;
        }
    }

    static Room createNewRoom(Scanner in) {

        try {
            System.out.print("Podaj numer pokoju: ");
            int number = in.nextInt();
            System.out.print("Podaj licznę łóżek: ");
            int beds = in.nextInt();

            Room newRoom = new Room(number, beds);

            String newRoomInfo = String.format("Utworzono nowy pokój - numer %d; łóżek: %d", newRoom.number, newRoom.beds);
            System.out.println(newRoomInfo);
            return newRoom;
        } catch (Exception e) {
            System.out.println("Podane dane muszą być liczbami!");
            e.printStackTrace();
            return null;
        }
    }

}
