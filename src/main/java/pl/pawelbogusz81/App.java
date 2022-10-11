package pl.pawelbogusz81;

import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.ui.text.TextUI;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;

public class App {

    private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {

        try {
            Properties.createDataDirectory();
        } catch (IOException e) {
            throw new IOCustomException(Properties.DATA_DIRECTORY.toString(), "Creating directory", "Creating data directory error");
        }
        textUI.showSystemInfo();
        textUI.showMainMenu();
        //testowy komentarz
    }
}
