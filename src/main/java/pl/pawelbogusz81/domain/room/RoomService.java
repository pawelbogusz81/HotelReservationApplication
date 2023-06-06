package pl.pawelbogusz81.domain.room;

import pl.pawelbogusz81.domain.ObjectPool;
import pl.pawelbogusz81.domain.room.dto.RoomDTO;
import pl.pawelbogusz81.exceptions.WrongOptionException;

import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private final RoomRepository roomRepository = ObjectPool.getRoomRepository();

    private final static RoomService instance = new RoomService();

    private RoomService(){

    }

    public Room createNewRoom(int number, List<String> bedTypesAsString) {

        BedType[] bedTypes = new BedType[bedTypesAsString.size()];

        for (int i = 0; i < bedTypesAsString.size(); i++) {
            BedType bedType;
            if (bedTypesAsString.get(i).equals("Pojedyncze")) {
                bedType = BedType.SINGLE;
            } else if (bedTypesAsString.get(i).equals("Podwójne")) {
                bedType = BedType.DOUBLE;
            } else if (bedTypesAsString.get(i).equals("Królewskie")) {
                bedType = BedType.KING_SIZE;
            } else {
                throw new WrongOptionException("Wrong option in bed's type menu.");
            }
            bedTypes[i] = bedType;
        }

        return roomRepository.createNewRoom(number, bedTypes);
    }

    public Room createNewRoom(int number, int[] bedTypesOptions) {

        BedType[] bedTypes = new BedType[bedTypesOptions.length];

        for (int i = 0; i < bedTypesOptions.length; i++) {

            BedType bedType;
            if (bedTypesOptions[i] == 1) {
                bedType = BedType.SINGLE;
            } else if (bedTypesOptions[i] == 2) {
                bedType = BedType.DOUBLE;
            } else if (bedTypesOptions[i] == 3) {
                bedType = BedType.KING_SIZE;
            } else {
                throw new WrongOptionException("Wrong option in bed's type menu.");
            }
            bedTypes[i] = bedType;
        }

        return roomRepository.createNewRoom(number, bedTypes);
    }

    public List<Room> getAllRooms() {
        return this.roomRepository.getAll();
    }

    public void saveAll() {
        this.roomRepository.saveAll();
    }

    public void readAll() {
        this.roomRepository.readAll();
    }

    public void removeRoom(int id) {
        this.roomRepository.remove(id);
    }

    public void editRoom(int id, int number, int[] bedTypesOptions) {

        BedType[] bedTypes = new BedType[bedTypesOptions.length];

        for (int i = 0; i < bedTypesOptions.length; i++) {

            BedType bedType;
            if (bedTypesOptions[i] == 1) {
                bedType = BedType.SINGLE;
            } else if (bedTypesOptions[i] == 2) {
                bedType = BedType.DOUBLE;
            } else if (bedTypesOptions[i] == 3) {
                bedType = BedType.KING_SIZE;
            } else {
                throw new WrongOptionException("Wrong option in bed's type menu.");
            }
            bedTypes[i] = bedType;
        }

        this.roomRepository.edit(id, number, bedTypes);
    }

    public Room getRoomByID(int roomId) {
        return this.roomRepository.getRoomById(roomId);
    }

    public List<RoomDTO> getAllAsDTO() {
        List<RoomDTO> result = new ArrayList<>();
        List<Room> allRooms = roomRepository.getAll();

        for (Room room : allRooms) {
            RoomDTO dto = room.generateDTO();
            result.add(dto);
        }
        return result;
    }

    public static RoomService getInstance() {
        return instance;
    }
}
