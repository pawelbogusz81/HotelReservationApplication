public class RoomRepository {

    public RoomRepository(){
    }

    public Room createNewRoom(int number, BedType[] bedType) {

            return new Room(number, bedType);
    }
}
