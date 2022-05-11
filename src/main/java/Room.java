public class Room {

    private int number;
    private BedType[] beds;

    public Room(int number, BedType[] bedType) {
        this.number = number;
        this.beds = bedType;
    }

    public String getInfo() {

        String bedInfo = "Wybrane łóżka w pokoju: \n";

        for (BedType bed : beds) {
            bedInfo = bedInfo + "\t" + bed + "\n";

        }
        return String.format("Utworzono nowy pokój - numer: %d, %s", this.number, bedInfo);

    }

}
