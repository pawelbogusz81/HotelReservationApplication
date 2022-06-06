package pl.pawelbogusz81.domain.room;

import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private final List<Room> rooms = new ArrayList<>();

    Room createNewRoom(int number, BedType[] bedType) {
        Room newRoom = new Room(findNewId(), number, bedType);
        rooms.add(newRoom);
        return newRoom;
    }

    Room addNewRoomFromFile(int id, int number, BedType[] bedType) {
        Room newRoom = new Room(id, number, bedType);
        rooms.add(newRoom);
        return newRoom;
    }

    List<Room> getAll() {
        return rooms;
    }

    void saveAll() {
        String name = "rooms.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);
        StringBuilder stringBuilder = new StringBuilder();

        for (Room room : this.rooms) {
            stringBuilder.append(room.toCSV());
        }

        try {
            Files.writeString(file, stringBuilder.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOCustomException(file.toString(), "Creating file error", "Room data");
        }
    }

    void readAll() {

        String name = "rooms.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        if (!Files.exists(file)) {
            return;
        }

        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] roomsAsString = data.split(System.getProperty("line.separator"));

            for (String roomAsString : roomsAsString) {
                String[] roomData = roomAsString.split(",");
                int id = Integer.parseInt(roomData[0]);
                int number = Integer.parseInt(roomData[1]);
                String bedTypesData = roomData[2];
                String[] bedTypesAsString = bedTypesData.split("#");
                BedType[] bedTypes = new BedType[bedTypesAsString.length];

                for (int i = 0; i < bedTypes.length; i++) {
                    bedTypes[i] = BedType.valueOf(bedTypesAsString[i]);
                }

                addNewRoomFromFile(id, number, bedTypes);
            }

        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi.");
            throw new IOCustomException(file.toString(), "Reading file error", "Room data");
        }
    }

    private int findNewId() {

        int max = 0;
        for (Room room: this.rooms) {
            if (room.getId() > max) {
                max = room.getId();
            }
        }
        return max + 1;
    }
}
