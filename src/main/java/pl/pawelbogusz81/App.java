package pl.pawelbogusz81;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.ui.gui.PrimaryStage;
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
        PrimaryStage primary = new PrimaryStage();
        primary.initialize(primaryStage);
    }
}
