package pl.pawelbogusz81.domain.guest;

import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.guest.dto.GuestDTO;

import java.util.ArrayList;
import java.util.List;

public class GuestService {

    private final GuestRepository guestRepository = ObjectPool.getGuestRepository();

    private final static GuestService instance = new GuestService();

    private GuestService() {
    }

    public Guest createNewGuest(String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        return guestRepository.createNewGuest(firstName, lastName, age, gender);
    }

    public List<Guest> getAllGuests() {

        return guestRepository.getAll();
    }

    public void saveAll() {
        guestRepository.saveAll();
    }

    public void readAll() {
        guestRepository.readAll();
    }

    public void removeGuest(int id) {
        guestRepository.remove(id);
    }

    public void editGuest(int id, String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        guestRepository.edit(id, firstName, lastName, age, gender);
    }

    public Guest getGuestByID(int guestId) {
        return guestRepository.findById(guestId);
    }

    public List<GuestDTO> getAllAsDTO() {

        List<GuestDTO> result = new ArrayList<>();
        List<Guest> allGuests = guestRepository.getAll();

        for (Guest guest : allGuests) {
            GuestDTO dto = guest.generateDTO();
            result.add(dto);
        }
        return result;
    }

    public static GuestService getInstance(){
        return instance;
    }

}
