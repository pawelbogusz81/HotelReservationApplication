package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.pawelbogusz81.domain.reservation.ReservationService;
import pl.pawelbogusz81.domain.reservation.dto.ReservationDTO;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;

import java.util.List;

public class ReservationsTab {

    private Tab reservationTab;
    private ReservationService reservationService = new ReservationService();

    public ReservationsTab() {

        TableView<ReservationDTO> tableView = new TableView();

        //pole "room"
        TableColumn<ReservationDTO, String> roomInfo= new TableColumn<>("Pokój");
        roomInfo.setCellValueFactory(new PropertyValueFactory<>("roomInfo"));

        //pole "guest"
        TableColumn<ReservationDTO, String> guestInfo= new TableColumn<>("Gość");
        guestInfo.setCellValueFactory(new PropertyValueFactory<>("guestInfo"));

        //pole "id"
        TableColumn<ReservationDTO, Integer> idColumn= new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));


        tableView.getColumns().addAll(idColumn, roomInfo, guestInfo);

        List<ReservationDTO> allAsDTO = reservationService.getAllAsDTO();

        tableView.getItems().addAll(allAsDTO);

        this.reservationTab = new Tab("Rezerwacje", tableView);
        this.reservationTab.setClosable(false);
    }

    public Tab getReservationTab(){
        return this.reservationTab;
    }
}
