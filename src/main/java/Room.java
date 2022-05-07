public class Room {

    private int number;
    private BedType[] beds;

    public Room(int number, BedType[] bedType) {
        this.number = number;
        this.beds = bedType;
    }

    public String getInfo() {

        System.out.println("Wybrane łóżka w pokoju:");

        int numberOfBeds = beds.length;
        for (int i = 0; i < numberOfBeds; i = i + 1) {
            System.out.println(beds[i]);
        }
        return String.format("Utworzono nowy pokój - numer: %d", this.number);

    }

}
