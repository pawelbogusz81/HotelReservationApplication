package pl.pawelbogusz81.domain.room;

public class Room {

    private final int number;
    private final BedType[] beds;

    Room(int number, BedType[] bedType) {
        this.number = number;
        this.beds = bedType;
    }

    public String getInfo() {

        StringBuilder bedInfo = new StringBuilder("Wybrane łóżka w pokoju: \n");

        for (BedType bed : beds) {
            bedInfo.append("\t").append(bed).append("\n");

        }
        return String.format("Utworzono nowy pokój - numer: %d, %s", this.number, bedInfo);

    }

}
