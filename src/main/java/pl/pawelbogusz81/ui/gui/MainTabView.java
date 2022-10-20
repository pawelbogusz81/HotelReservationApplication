package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTabView {

    private TabPane mainTabs;

    public MainTabView(){
        this.mainTabs = new TabPane();


        Tab guestsTab = new Tab("Goście", new Label("Obsługa gości"));


        guestsTab.setClosable(false);

        ReservationsTab reservationsTab = new ReservationsTab();

        RoomsTab roomsTab = new RoomsTab();
        this.mainTabs.getTabs().addAll(reservationsTab.getReservationTab(), guestsTab, roomsTab.getRoomTab());
    }

    public TabPane getMainTabs() {
        return mainTabs;
    }
}
