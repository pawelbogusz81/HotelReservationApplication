package pl.pawelbogusz81.domain.room;

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
        Room newRoom = new Room(number, bedType);
        rooms.add(newRoom);
        return newRoom;
    }

    List<Room> getAll() {
        return rooms;
    }

    void saveAll() {
        String name = "rooms.csv";
        Path file = Paths.get(System.getProperty("user.home"), "Reservation_system", name);
        StringBuilder stringBuilder = new StringBuilder();

        for (Room room : this.rooms) {
            stringBuilder.append(room.toCSV());
        }

        try {
            Path reservation_system_dir = Paths.get(System.getProperty("user.home"), "Reservation_system");
            if (!Files.isDirectory(reservation_system_dir)) {
                Files.createDirectory(reservation_system_dir);
            }
            Files.writeString(file, stringBuilder.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readAll() {

        String name = "rooms.csv";
        Path file = Paths.get(System.getProperty("user.home"), "Reservation_system", name);

        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] roomsAsString = data.split(System.getProperty("line.separator"));

            for (String roomAsString : roomsAsString) {
                String[] roomData = roomAsString.split(",");
                int number = Integer.parseInt(roomData[0]);
                String bedTypesData = roomData[1];
                String[] bedTypesAsArray = bedTypesData.split("#");
                BedType[] bedTypes = new BedType[bedTypesAsArray.length];

                for (int i = 0; i < bedTypes.length; i++) {
                    bedTypes[i] = BedType.valueOf(bedTypesAsArray[i]);
                }

                createNewRoom(number, bedTypes);
            }

        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi.");
            e.printStackTrace();
        }
    }
}
