package pl.pawelbogusz81.domain.guest;

import pl.pawelbogusz81.domain.guest.dto.GuestDTO;

public class Guest {


    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;


    Guest(int id, String firstName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public final String getInfo() {
        return String.format("\t(%d) %s %s (%d, %s)",this.id, this.firstName, this.lastName, this.age, this.gender);
    }

    String toCSV() {
        return String.format("%d,%s,%s,%d,%s%s",
                this.id,
                this.firstName,
                this.lastName,
                this.age,
                this.gender,
                System.getProperty("line.separator"));
    }

    public GuestDTO generateDTO() {
        return new GuestDTO(this.id, this.firstName, this.lastName, this.age, this.gender.toString());
    }
}
