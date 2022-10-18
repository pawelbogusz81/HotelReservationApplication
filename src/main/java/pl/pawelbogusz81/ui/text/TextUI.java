package pl.pawelbogusz81.ui.text;

import pl.pawelbogusz81.domain.reservation.Reservation;
import pl.pawelbogusz81.domain.reservation.ReservationService;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.exceptions.OnlyNumberException;
import pl.pawelbogusz81.exceptions.WrongOptionException;
import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.room.Room;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.util.Properties;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {

    private final GuestService guestService = new GuestService();
    private final RoomService roomService = new RoomService();
    private final ReservationService reservationService = new ReservationService();

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

    public void showSystemInfo() {

        System.out.println("Witam w systemie rezerwacji dla hotelu: " + Properties.HOTEL_NAME);
        System.out.println("Aktualna wersja systemu: " + Properties.SYSTEM_VERSION);
        System.out.println("Wersja developerska: " + Properties.IS_DEVELOPER_VERSION);
        System.out.println("\n=========================\n");
    }

    public void showMainMenu() {

        System.out.println("Trwa wczytywanie danych...");
        this.guestService.readAll();
        this.roomService.readAll();
        this.reservationService.readAll();

        Scanner input = new Scanner(System.in);

        try {
            performAction(input);
        } catch (WrongOptionException | OnlyNumberException | IOCustomException e) {
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
            } else if (option == 4) {
                System.out.println("Wypisywanie wszystkich pokoi...");
                showAllRooms();
            } else if (option == 5) {
                System.out.println("Usuwanie gości z bazy...");
                removeGuest(input);
            } else if (option == 6) {
                System.out.println("Edycja gości z bazy...");
                editGuest(input);
            } else if (option == 7) {
                System.out.println("Usuwanie pokoju z bazy...");
                removeRoom(input);
            } else if (option == 8) {
                System.out.println("Edycja pokoju z bazy...");
                editRoom(input);
            } else if (option == 9) {
                System.out.println("Tworzenie rezerwacji...");
                createReservation(input);
            }  else if (option == 0) {
                System.out.println("Zapisuję i wychodzę z aplikacji");
                this.guestService.saveAll();
                this.roomService.saveAll();
                this.reservationService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu.");
            }
        }
    }

    private void createReservation(Scanner input) {

        System.out.print("Od kiedy (DD.MM.YYYY): ");
        String fromAsString = input.next();
        LocalDate from = LocalDate.parse(fromAsString, Properties.DATE_FORMATTER);

        System.out.print("Do kiedy (DD.MM.YYYY): ");
        String toAsString = input.next();
        LocalDate to = LocalDate.parse(toAsString, Properties.DATE_FORMATTER);

        System.out.print("ID pokoju: ");
        int roomId = input.nextInt();
        System.out.print("ID gościa: ");
        int guestId = input.nextInt();

        try{
            Reservation res = this.reservationService.createReservation(from, to, roomId, guestId);
            if (res != null) {
                System.out.println("Rezerwacja została utworzona.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Data rozpoczęcia musi być wcześniejsza jak data zakończenia.");
        }


    }

    private void editRoom(Scanner input) {
        System.out.print("Podaj ID pokoju do edycji: ");

        try {
            int id = input.nextInt();
            System.out.print("Podaj numer pokoju: ");
            int number = input.nextInt();
            int[] bedTypes = chooseBedType(input);
            this.roomService.editRoom(id, number, bedTypes);

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers typing room number or number of beds");
        }
    }

    private void removeRoom(Scanner input) {
        System.out.print("Podaj ID pokoju do usunięcia: ");
        try {
            int id = input.nextInt();
            this.roomService.removeRoom(id);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers while choosing ID deleted Room");
        }
    }

    private void editGuest(Scanner input) {
        System.out.print("Podaj ID gościa do edycji: ");

        try {
            int id = input.nextInt();

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

                this.guestService.editGuest(id, firstName, lastName, age, isFemale);




        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers while choosing ID modified Guest");
        }
    }

    private void removeGuest(Scanner input) {
        System.out.print("Podaj ID gościa do usunięcia: ");
        try {
            int id = input.nextInt();
            this.guestService.removeGuest(id);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers while choosing ID deleted Guest");
        }
    }

    private void showAllRooms() {
        System.out.println("Lista pokoi w hotelu:");
        List<Room> rooms = this.roomService.getAllRooms();

        for (Room room : rooms) {
            System.out.println(room.getInfo());
        }
    }

    private void showAllGuest() {

        System.out.println("Lista gości w hotelu:");
        List<Guest> guests = this.guestService.getAllGuests();

        for (Guest guest : guests) {
            System.out.println(guest.getInfo());
        }
    }

    private int getActionFromUser(Scanner in) {
        System.out.println("Dostępne opcje systemu:");
        System.out.println("\t1. Dodaj nowego gościa.");
        System.out.println("\t2. Dodaj nowy pokój.");
        System.out.println("\t3. Wypisz wszystkich gości.");
        System.out.println("\t4. Wypisz wszystkie pokoje.");
        System.out.println("\t5. Usuwanie gościa.");
        System.out.println("\t6. Edycja gościa.");
        System.out.println("\t7. Usuwanie pokoju.");
        System.out.println("\t8. Edycja pokoju.");
        System.out.println("\t9. Tworzenie rezerwacji.");
        System.out.println("\t0. Zapisz i wyjdź z aplikacji.");
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
