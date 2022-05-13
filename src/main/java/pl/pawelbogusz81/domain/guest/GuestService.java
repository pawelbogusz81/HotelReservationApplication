package pl.pawelbogusz81.domain.guest;

public class GuestService {

    GuestRepository repository = new GuestRepository();

    public Guest createNewGuest (String firstName, String lastName, int age, int genderOption) {
        Gender gender = Gender.MALE;

        if (genderOption == 1) {
            gender = Gender.FEMALE;
        } else if (genderOption == 2) {
            gender = Gender.MALE;
        }

        return repository.createNewGuest(firstName, lastName, age, gender);
    }
}
