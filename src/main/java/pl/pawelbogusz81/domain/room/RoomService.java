package pl.pawelbogusz81.domain.room;

import pl.pawelbogusz81.exceptions.WrongOptionException;

import java.util.List;

public class RoomService {

    private final RoomRepository roomRepository = new RoomRepository();

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

        roomRepository.edit(id, number, bedTypes);
    }
}
