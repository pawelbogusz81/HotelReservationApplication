package pl.pawelbogusz81.domain.room;

public class Room {

    private final int id;
    private final int number;
    private final BedType[] beds;

    Room(int id, int number, BedType[] bedType) {
        this.id = id;
        this.number = number;
        this.beds = bedType;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {

        StringBuilder bedInfo = new StringBuilder("Wybrane łóżka w pokoju: \n");

        for (BedType bed : beds) {
            bedInfo.append("\t").append(bed).append("\n");
        }
        return String.format("Pokój numer: %d (ID %d), %s", this.number, this.id, bedInfo);
    }

    String toCSV() {

        String[] bedsAsString = new String[this.beds.length];

        for (int i = 0; i < this.beds.length; i++){
            bedsAsString[i] = this.beds[i].toString();
        }

        String bedTypes = String.join("#", bedsAsString);

        return String.format("%d,%d,%s%s",
                this.id,
                this.number,
                bedTypes,
                System.getProperty("line.separator"));
    }

}
