package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTabView {

    private TabPane mainTabs;

    public MainTabView(){
        this.mainTabs = new TabPane();

        Tab reservationsTab = new Tab("Rezerwacje", new Label("Obsługa rezerwacji"));
        Tab roomsTab = new Tab("Pokoje", new Label("Obsługa pokoi"));
        Tab guestsTab = new Tab("Goście", new Label("Obsługa gości"));

        reservationsTab.setClosable(false);
        guestsTab.setClosable(false);
        roomsTab.setClosable(false);

        this.mainTabs.getTabs().addAll(reservationsTab, guestsTab, roomsTab);
    }

    public TabPane getMainTabs() {
        return mainTabs;
    }
}
