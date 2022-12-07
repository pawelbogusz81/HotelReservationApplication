package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainTabView {

    private TabPane mainTabs;

    public MainTabView(final Stage primaryStage){
        this.mainTabs = new TabPane();


        ReservationsTab reservationsTab = new ReservationsTab();
        GuestsTab guestsTab = new GuestsTab();
        RoomsTab roomsTab = new RoomsTab(primaryStage);
        this.mainTabs.getTabs().addAll(reservationsTab.getReservationTab(), guestsTab.getGuestsTab(), roomsTab.getRoomTab());
    }

    public TabPane getMainTabs() {
        return mainTabs;
    }
}
