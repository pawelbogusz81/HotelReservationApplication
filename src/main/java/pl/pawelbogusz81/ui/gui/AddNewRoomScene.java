package pl.pawelbogusz81.ui.gui;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddNewRoomScene {

    private Scene mainScene;

    public AddNewRoomScene(){

        Label roomNumberLabel = new Label("Numer pokoju");
        TextField imputedRoomNumber = new TextField("Wpisz numer pokoju");
        HBox roomNumberRow = new HBox(roomNumberLabel, imputedRoomNumber);

        Label bedTypeLabel = new Label("Rodzaj łóżka");
        ComboBox bedTypeBox = new ComboBox<>();
        bedTypeBox.getItems().addAll("Pojedyncze", "Podwójne", "Królewskie");
        bedTypeBox.setValue("Pojedyncze");
        HBox bedTypeRow = new HBox(bedTypeLabel, bedTypeBox);

        VBox box = new VBox(roomNumberRow, bedTypeRow);

        this.mainScene = new Scene(box,640,480);

    }

    Scene getMainScene() {



        return mainScene;
    }
}
