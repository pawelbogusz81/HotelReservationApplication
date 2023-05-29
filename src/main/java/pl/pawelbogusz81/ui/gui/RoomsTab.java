package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;

import java.util.List;

public class RoomsTab {
    private Tab roomTab;
    private RoomService roomService = ObjectPool.getRoomService();

    public RoomsTab() {

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

        this.roomTab = new Tab("Pokoje", tableView);
        this.roomTab.setClosable(false);
    }

    public Tab getRoomTab() {
        return roomTab;
    }
}
