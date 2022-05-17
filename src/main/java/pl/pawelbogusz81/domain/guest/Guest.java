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

    public final String getInfo() {
        return String.format("\t%s %s (%d, %s)", this.firstName, this.lastName, this.age, this.gender);
    }

    String toCSV() {
         return String.format("%s,%s,%d,%s\n", this.firstName, this.lastName, this.age, this.gender);
    }

}
