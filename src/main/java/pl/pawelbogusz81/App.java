package pl.pawelbogusz81;

import pl.pawelbogusz81.ui.text.TextUI;

public class App {

    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 2;
        boolean isDeveloperVersion = true;

        textUI.showSystemInfo(hotelName, systemVersion, isDeveloperVersion);
        textUI.showMainMenu();
    }
}
