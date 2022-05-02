public class Room {

    private int number;
    private int beds;

    Room(int number, int beds) {
        this.number = number;
        this.beds = beds;
    }

    public String getInfo() {
        return String.format("Utworzono nowy pokój - numer: %d; łóżek: %d", number, beds);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
}
