package pl.pawelbogusz81;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.ui.text.TextUI;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;

public class App extends Application {

//    private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {

        try {
            Properties.createDataDirectory();
        } catch (IOException e) {
            throw new IOCustomException(Properties.DATA_DIRECTORY.toString(), "Creating directory", "Creating data directory error");
        }
        Application.launch(args);
//        textUI.showSystemInfo();
//        textUI.showMainMenu();
    }

    public void start(Stage primaryStage){
        String hotelName = Properties.HOTEL_NAME;
        int systemVersion = Properties.SYSTEM_VERSION;
        Label l = new Label("Hello JavaFX.");
        Scene scene = new Scene(l,800,600);
        String title = String.format("System rezerwacji hotelu %s (ver. %d)", hotelName, systemVersion);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
