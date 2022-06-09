package pl.pawelbogusz81.domain.guest;

import java.util.List;

public class GuestService {

    private final GuestRepository repository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        return this.repository.createNewGuest(firstName, lastName, age, gender);
    }

    public List<Guest> getAllGuests() {

        return this.repository.getAll();
    }

    public void saveAll() {
        this.repository.saveAll();
    }

    public void readAll() {
        this.repository.readAll();
    }

    public void removeGuest(int id) {
        this.repository.remove(id);
    }

    public void editGuest(int id, String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        this.repository.edit(id, firstName, lastName, age, gender);
    }
}
