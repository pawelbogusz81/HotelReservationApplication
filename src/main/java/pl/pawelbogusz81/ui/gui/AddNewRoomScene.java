package pl.pawelbogusz81.ui.gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class AddNewRoomScene {

    private final Scene mainScene;
    private List<ComboBox<String>> comboBoxes = new ArrayList<>();
    private final RoomService roomService = ObjectPool.getRoomService();

    public AddNewRoomScene(final Stage addRoomPopup, final TableView<RoomDTO> tableView){

        Label roomNumberLabel = new Label("Numer pokoju");
        TextField imputedRoomNumber = new TextField();
        HBox roomNumberRow = new HBox(roomNumberLabel, imputedRoomNumber);

        Label bedTypeLabel = new Label("Rodzaje łóżek");
        Button addNewBedButton = new Button("Dodaj");
        HBox bedTypeRow = new HBox(bedTypeLabel, addNewBedButton);

        VBox bedsVerticalBox = new VBox(bedTypeRow, getComboBox());

        addNewBedButton.setOnAction(event -> bedsVerticalBox.getChildren().add(getComboBox()));

        Button addNewRoomBtn = new Button("Dodaj nowy pokój");
        addNewRoomBtn.setOnAction(event -> {
            int newRoomNumber = Integer.parseInt(imputedRoomNumber.getText());
            System.out.println(newRoomNumber);
            List<String> bedTypes = new ArrayList<>();

            this.comboBoxes.forEach(comboBox -> {
                bedTypes.add(comboBox.getValue());
            });

            this.roomService.createNewRoom(newRoomNumber, bedTypes);

            tableView.getItems().clear();

            List<RoomDTO> allAsDTO = roomService.getAllAsDTO();
            tableView.getItems().addAll(allAsDTO);

//            System.out.println(roomService.getRoomByID(3).getRoomInfo());
            addRoomPopup.close();
        });

        VBox box = new VBox(roomNumberRow, bedsVerticalBox, addNewRoomBtn);

        this.mainScene = new Scene(box,640,480);

    }

    private ComboBox<String> getComboBox() {
        ComboBox<String> bedTypeBox = new ComboBox<>();
        bedTypeBox.getItems().addAll("Pojedyncze", "Podwójne", "Królewskie");
        bedTypeBox.setValue("Pojedyncze");
        comboBoxes.add(bedTypeBox);
        return bedTypeBox;
    }

    public Scene getMainScene() {

        return mainScene;
    }
}
