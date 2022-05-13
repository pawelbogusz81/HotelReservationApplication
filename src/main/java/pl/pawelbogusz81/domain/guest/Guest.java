package pl.pawelbogusz81.domain.guest;

public class Guest {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;


     Guest(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getInfo() {
        return String.format("Utworzono nowego gościa: %s %s (%d, %s)", firstName, lastName, age, gender);
    }

}
