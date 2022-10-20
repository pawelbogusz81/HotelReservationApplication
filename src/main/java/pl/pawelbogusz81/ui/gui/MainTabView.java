package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTabView {

    private TabPane mainTabs;

    public MainTabView(){
        this.mainTabs = new TabPane();


        ReservationsTab reservationsTab = new ReservationsTab();
        GuestsTab guestsTab = new GuestsTab();
        RoomsTab roomsTab = new RoomsTab();
        this.mainTabs.getTabs().addAll(reservationsTab.getReservationTab(), guestsTab.getGuestsTab(), roomsTab.getRoomTab());
    }

    public TabPane getMainTabs() {
        return mainTabs;
    }
}
