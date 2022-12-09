package pl.pawelbogusz81.ui.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AddNewRoomScene {

    private final Scene mainScene;
    private final List<ComboBox<String>> comboBoxes = new ArrayList<>();

    public AddNewRoomScene(){

        Label roomNumberLabel = new Label("Numer pokoju");
        TextField imputedRoomNumber = new TextField("Wpisz numer pokoju");
        HBox roomNumberRow = new HBox(roomNumberLabel, imputedRoomNumber);

        Label bedTypeLabel = new Label("Rodzaje łóżek");
        Button addNewBedButton = new Button("Dodaj");


        HBox bedTypeRow = new HBox(bedTypeLabel, addNewBedButton);

        VBox bedsVerticalBox = new VBox(bedTypeRow, getComboBox());

        addNewBedButton.setOnAction(event -> bedsVerticalBox.getChildren().add(getComboBox()));

        VBox box = new VBox(roomNumberRow, bedsVerticalBox);

        this.mainScene = new Scene(box,640,480);

    }

    private ComboBox<String> getComboBox() {
        ComboBox<String> bedTypeBox = new ComboBox<>();
        bedTypeBox.getItems().addAll("Pojedyncze", "Podwójne", "Królewskie");
        bedTypeBox.setValue("Pojedyncze");
        return bedTypeBox;
    }

    Scene getMainScene() {



        return mainScene;
    }
}
