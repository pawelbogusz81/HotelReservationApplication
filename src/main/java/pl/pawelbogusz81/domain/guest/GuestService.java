package pl.pawelbogusz81.domain.guest;

public class GuestService {

    private final GuestRepository repository = new GuestRepository();

    public Guest createNewGuest (String firstName, String lastName, int age, boolean isFemale) {

        Gender gender = Gender.MALE;

        if (isFemale) {
            gender = Gender.FEMALE;
        }

        return repository.createNewGuest(firstName, lastName, age, gender);
    }
}
