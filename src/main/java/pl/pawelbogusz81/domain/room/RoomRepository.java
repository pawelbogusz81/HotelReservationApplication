package pl.pawelbogusz81.domain.room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private final List<Room> rooms = new ArrayList<>();

    Room createNewRoom(int number, BedType[] bedType) {
        Room newRoom = new Room(number, bedType);
        rooms.add(newRoom);
        return newRoom;
    }

    List<Room> getAll() {
        return rooms;
    }
}
