import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = true;

        System.out.print("Witam w systemie rezerwacji dla hotelu: " + hotelName);
        System.out.print("Aktualna wersja systemu: " + systemVersion);
        System.out.print("Wersja developerska: " + isDeveloperVersion);

        System.out.println("\n=========================\n");

        Scanner input = new Scanner(System.in);

        System.out.println("1. Dodaj nowego gościa.");
        System.out.println("2. Dodaj nowy pokój.");
        System.out.println("3. Wyszukaj gościa.");
        System.out.print("Wybierz opcję: ");

        int option = 0;

        try {
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejsciowe, wprowadz liczbę.");
            e.printStackTrace();
        }

        if (option == 1) {
            System.out.println("Tworzenie nowego gościa...");
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
            } catch (Exception e) {
                System.out.println("Podaj wiek jako liczbę!");
                e.printStackTrace();
            }

        } else if (option == 2) {
            System.out.println("Tworzenie nowego pokoju...");
            try {
                System.out.print("Podaj numer pokoju: ");
                int number = input.nextInt();
                System.out.print("Podaj licznę łóżek: ");
                int beds = input.nextInt();

                Room newRoom = new Room(number, beds);

                String newRoomInfo = String.format("Utworzono nowy pokój - numer %d; łóżek: %d", newRoom.number, newRoom.beds);
                System.out.println(newRoomInfo);
            } catch (Exception e) {
                System.out.println("Podane dane muszą być liczbami!");
                e.printStackTrace();
            }

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Wybrano niepoprawną akcję.");
        }
    }

}
