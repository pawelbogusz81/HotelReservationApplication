package pl.pawelbogusz81;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.reservation.ReservationService;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.ui.gui.PrimaryStage;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;

public class App extends Application {

//    private static final TextUI textUI = new TextUI();
    private static final GuestService guestService = new GuestService();
    private static final RoomService roomService = new RoomService();
    private static final ReservationService reservationService = new ReservationService();

    public static void main(String[] args) {

        try {
            Properties.createDataDirectory();
            System.out.println("Trwa wczytywanie danych...");
            guestService.readAll();
            roomService.readAll();
            reservationService.readAll();
        } catch (IOException e) {
            throw new IOCustomException(Properties.DATA_DIRECTORY.toString(), "Creating directory", "Creating data directory error");
        }
        Application.launch(args);
//        textUI.showSystemInfo();
//        textUI.showMainMenu();
    }

    public void start(Stage primaryStage){
        PrimaryStage primary = new PrimaryStage();
        primary.initialize(primaryStage);
    }
}
