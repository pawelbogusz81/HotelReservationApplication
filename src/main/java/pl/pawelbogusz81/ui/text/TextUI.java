package pl.pawelbogusz81.ui.text;

import pl.pawelbogusz81.exceptions.OnlyNumberException;
import pl.pawelbogusz81.exceptions.WrongOptionException;
import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.room.Room;
import pl.pawelbogusz81.domain.room.RoomService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {

    private final GuestService guestService = new GuestService();
    private final RoomService roomService = new RoomService();

    private void readNewGuestData(Scanner input) {

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
            boolean isFemale;

            if (genderOption == 1) {
                isFemale = true;
            } else if (genderOption == 2) {
                isFemale = false;
            } else {
                throw new WrongOptionException("Wrong option in gender menu.");
            }

            Guest newGuest = guestService.createNewGuest(firstName, lastName, age, isFemale);
            System.out.println(newGuest.getInfo());

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing your age");
        }
    }

    private void readNewRoomData(Scanner input) {

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

    private int[] chooseBedType(Scanner input) {
        System.out.print("Ile łóżek w pokoju?: ");
        int bedNumber = input.nextInt();

        int[] bedTypes = new int[bedNumber];


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

    public void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {

        System.out.println("Witam w systemie rezerwacji dla hotelu: " + hotelName);
        System.out.println("Aktualna wersja systemu: " + systemVersion);
        System.out.println("Wersja developerska: " + isDeveloperVersion);

        System.out.println("\n=========================\n");
    }

    public void showMainMenu() {

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
        }
    }

    private void performAction(Scanner input) {

        int option = -1;
        while (option != 0) {

            option = getActionFromUser(input);

            if (option == 1) {
                System.out.println("Tworzenie nowego gościa...");
                readNewGuestData(input);

            } else if (option == 2) {
                System.out.println("Tworzenie nowego pokoju...");
                readNewRoomData(input);
            } else if (option == 3) {
                System.out.println("Wypisywanie wszystkich gości...");
                showAllGuest();
            } else if (option == 0) {
                System.out.println("Wychodzę z aplikacji");
            } else {
                throw new WrongOptionException("Wrong option in main menu.");
            }
        }
    }

    private void showAllGuest() {

        System.out.println("Lista gości w hotelu:");
        List<Guest> guests =  this.guestService.getAllGuests();

        for (Guest guest : guests){
            System.out.println(guest.getInfo());
        }
    }

    private int getActionFromUser(Scanner in) {
        System.out.println("Dostępne opcje systemu:");
        System.out.println("\t1. Dodaj nowego gościa.");
        System.out.println("\t2. Dodaj nowy pokój.");
        System.out.println("\t3. Wypisz wszystkich gości.");
        System.out.println("\t0. Wyjście z aplikacji.");
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
