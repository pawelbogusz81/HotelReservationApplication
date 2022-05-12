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
        RoomService roomService = new RoomService();


        if (option == 1) {
            System.out.println("Tworzenie nowego gościa...");
            textUI.readNewGuestData(input);

        } else if (option == 2) {
            System.out.println("Tworzenie nowego pokoju...");
            textUI.readNewRoomData(input);
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

        int actionNumber;

        try {
            actionNumber = in.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu.");
        }
        return actionNumber;
    }
}
