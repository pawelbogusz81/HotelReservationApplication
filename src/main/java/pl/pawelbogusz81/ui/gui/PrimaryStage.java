package pl.pawelbogusz81.ui.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import pl.pawelbogusz81.util.Properties;

public class PrimaryStage {

    public void initialize(Stage primaryStage){

        String hotelName = Properties.HOTEL_NAME;
        int systemVersion = Properties.SYSTEM_VERSION;

        MainTabView mainTabView = new MainTabView();

        TabPane mainTabs = mainTabView.getMainTabs();

        Scene scene = new Scene(mainTabs,800,600);
        String title = String.format("System rezerwacji hotelu %s (ver. %d)", hotelName, systemVersion);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
