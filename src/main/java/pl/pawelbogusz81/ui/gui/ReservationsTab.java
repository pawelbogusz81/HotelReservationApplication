package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.reservation.ReservationService;
import pl.pawelbogusz81.domain.reservation.dto.ReservationDTO;

import java.util.List;

public class ReservationsTab {

    private Tab reservationTab;
    private ReservationService reservationService = ObjectPool.getReservationService();

    public ReservationsTab() {

        TableView<ReservationDTO> tableView = new TableView();

        //pole "room"
        TableColumn<ReservationDTO, String> roomInfoColumn = new TableColumn<>("Pokój");
        roomInfoColumn.setCellValueFactory(new PropertyValueFactory<>("roomInfo"));

        //pole "guest"
        TableColumn<ReservationDTO, String> guestInfoColumn = new TableColumn<>("Gość");
        guestInfoColumn.setCellValueFactory(new PropertyValueFactory<>("guestInfo"));

        //pole "id"
        TableColumn<ReservationDTO, Integer> idColumn= new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        //pole "od"
        TableColumn<ReservationDTO, String> fromColumn= new TableColumn<>("Od");
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        //pole "do"
        TableColumn<ReservationDTO, String> toColumn= new TableColumn<>("Do");
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        tableView.getColumns().addAll(idColumn, roomInfoColumn, guestInfoColumn, fromColumn, toColumn);

        List<ReservationDTO> allAsDTO = reservationService.getAllAsDTO();

        tableView.getItems().addAll(allAsDTO);

        this.reservationTab = new Tab("Rezerwacje", tableView);
        this.reservationTab.setClosable(false);
    }

    public Tab getReservationTab(){
        return this.reservationTab;
    }
}
