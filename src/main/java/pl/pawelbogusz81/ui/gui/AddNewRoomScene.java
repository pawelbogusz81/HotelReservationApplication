package pl.pawelbogusz81.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;
import pl.pawelbogusz81.util.Properties;

import java.util.ArrayList;
import java.util.List;

public class AddNewRoomScene {

    private final Scene mainScene;
    private List<ComboBox<String>> comboBoxes = new ArrayList<>();
    private final RoomService roomService = ObjectPool.getRoomService();

    public AddNewRoomScene(final Stage addRoomPopup, final TableView<RoomDTO> tableView){

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);

        Label roomNumberLabel = new Label("Numer pokoju");
        TextField imputedRoomNumber = new TextField();

        imputedRoomNumber.textProperty().addListener((observableValue, oldValue, newValue) -> {

            if(!newValue.matches("\\d*")){
                imputedRoomNumber.setText(oldValue);
            }
        });

        gridPane.add(roomNumberLabel,0,0);
        gridPane.add(imputedRoomNumber,1,0);

        Label bedTypeLabel = new Label("Rodzaje łóżek");

        Button addNewBedButton = new Button();
        Image icon = new Image(getClass().getClassLoader().getResourceAsStream("add.jpg"));
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        addNewBedButton.setGraphic(imageView);
        addNewBedButton.setPadding(Insets.EMPTY);

        gridPane.add(bedTypeLabel,0,1);
        gridPane.add(addNewBedButton,1,1);

        VBox bedsVerticalBox = new VBox(getComboBox());

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

            addRoomPopup.close();
        });

        addNewBedButton.setPadding(new Insets(5,5,5,5));

        gridPane.add(bedsVerticalBox,1,2);
        gridPane.add(addNewRoomBtn,1,4);

        this.mainScene = new Scene(gridPane,640,480);
        this.mainScene
                .getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());

    }

    private ComboBox<String> getComboBox() {
        ComboBox<String> bedTypeBox = new ComboBox<>();
        bedTypeBox.getItems().addAll(Properties.SINGLE_BED,
                Properties.DOUBLE_BED,
                Properties.KING_SIZE);
        bedTypeBox.setValue(Properties.SINGLE_BED);
        comboBoxes.add(bedTypeBox);
        return bedTypeBox;
    }

    public Scene getMainScene() {

        return mainScene;
    }
}
