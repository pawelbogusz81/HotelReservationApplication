package pl.pawelbogusz81.domain.guest;

import java.util.List;

public class GuestService {

    private final static  GuestRepository roomRepository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        return roomRepository.createNewGuest(firstName, lastName, age, gender);
    }

    public List<Guest> getAllGuests() {

        return roomRepository.getAll();
    }

    public void saveAll() {
        roomRepository.saveAll();
    }

    public void readAll() {
        roomRepository.readAll();
    }

    public void removeGuest(int id) {
        roomRepository.remove(id);
    }

    public void editGuest(int id, String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        roomRepository.edit(id, firstName, lastName, age, gender);
    }

    public Guest getGuestByID(int guestId) {
        return roomRepository.findById(guestId);
    }
}
