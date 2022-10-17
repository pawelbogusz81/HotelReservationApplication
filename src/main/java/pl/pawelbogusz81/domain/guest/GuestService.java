package pl.pawelbogusz81.domain.guest;

import java.util.List;

public class GuestService {

    private final static  GuestRepository guestRepository = new GuestRepository();

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
}
