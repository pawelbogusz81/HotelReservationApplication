package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;

import java.util.List;

public class RoomsTab {
    private Tab roomTab;
    private RoomService roomService = ObjectPool.getRoomService();

    public RoomsTab(final Stage primaryStage) {

        TableView<RoomDTO> tableView = new TableView();

        //pole "number"
        TableColumn<RoomDTO, Integer> numberColumn= new TableColumn<>("Numer");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        //pole "beds"
        TableColumn<RoomDTO, String> bedsColumn= new TableColumn<>("Typy łóżek");
        bedsColumn.setCellValueFactory(new PropertyValueFactory<>("beds"));

        //pole "id"
        TableColumn<RoomDTO, Integer> idColumn= new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        //pole "ilość łóżek"
        TableColumn<RoomDTO, Integer> bedsCountColumn= new TableColumn<>("Łóżka");
        bedsCountColumn.setCellValueFactory(new PropertyValueFactory<>("bedsCount"));

        //pole "wielkość pokoju"
        TableColumn<RoomDTO, Integer> roomSizeColumn= new TableColumn<>("Max. osób");
        roomSizeColumn.setCellValueFactory(new PropertyValueFactory<>("roomSize"));


        tableView.getColumns().addAll(idColumn, numberColumn, roomSizeColumn, bedsCountColumn, bedsColumn);

        List<RoomDTO> allAsDTO = roomService.getAllAsDTO();

        tableView.getItems().addAll(allAsDTO);

        Button button = new Button("Dodaj pokój");

        button.setOnAction(event -> {
            Stage addRoomPopup = new Stage();
            addRoomPopup.initModality(Modality.WINDOW_MODAL);
            addRoomPopup.initOwner(primaryStage);
            addRoomPopup.setTitle("Dodawanie nowego pokoju");
            addRoomPopup.showAndWait();
        });

        VBox layout = new VBox(button, tableView);

        this.roomTab = new Tab("Pokoje", layout);
        this.roomTab.setClosable(false);
    }

    public Tab getRoomTab() {
        return roomTab;
    }
}
