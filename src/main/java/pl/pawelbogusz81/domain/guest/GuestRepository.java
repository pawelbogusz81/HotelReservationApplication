package pl.pawelbogusz81.domain.guest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {

    private final List<Guest> guests = new ArrayList<>();

    Guest createNewGuest(String firstName, String lastName, int age, Gender gender) {

        Guest newGuest = new Guest(firstName, lastName, age, gender);
        guests.add(newGuest);
        return newGuest;
    }

    List<Guest> getAll() {
        return this.guests;
    }

    void saveAll() {
        String name = "guests.csv";

        Path file = Paths.get(System.getProperty("user.home"), "Reservation_system", name);

        StringBuilder stringBuilder = new StringBuilder();

        for (Guest guest : this.guests) {
            stringBuilder.append(guest.toCSV());
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
}
