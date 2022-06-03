package pl.pawelbogusz81;

import pl.pawelbogusz81.ui.text.TextUI;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;

public class App {

    private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {

        try {
            Properties.createDataDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textUI.showSystemInfo();
        textUI.showMainMenu();
    }
}
