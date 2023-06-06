package pl.pawelbogusz81.ui.gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.guest.dto.GuestDTO;

import java.util.List;

public class GuestsTab {
    private Tab guestsTab;
    private GuestService guestService = ObjectPool.getGuestService();

    public GuestsTab() {

        TableView<GuestDTO> tableView = new TableView();

        //pole "id"
        TableColumn<GuestDTO, Integer> idColumn= new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        //pole "Imię"
        TableColumn<GuestDTO, Integer> firstNameColumn= new TableColumn<>("Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //pole "Nazwisko"
        TableColumn<GuestDTO, Integer> lastNameColumn= new TableColumn<>("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        //pole "wiek"
        TableColumn<GuestDTO, Integer> ageColumn= new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        //pole "płeć"
        TableColumn<GuestDTO, Integer> genderColumn= new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));


        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, ageColumn, genderColumn);

        List<GuestDTO> allAsDTO = guestService.getAllAsDTO();

        tableView.getItems().addAll(allAsDTO);

        this.guestsTab = new Tab("Goście", tableView);
        this.guestsTab.setClosable(false);

    }

    public Tab getGuestsTab() {
        return guestsTab;
    }
}
