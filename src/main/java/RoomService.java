import java.util.Scanner;


public class RoomService {

    RoomRepository roomRepository = new RoomRepository();

    public Room createNewRoom(Scanner input) {

        return roomRepository.createNewRoom(input);
    }
}
