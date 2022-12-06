package pl.pawelbogusz81.domain.reservation;

import pl.pawelbogusz81.domain.guest.Gender;
import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.room.Room;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.exceptions.IOCustomException;
import pl.pawelbogusz81.util.Properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    List<Reservation> reservations = new ArrayList<>();
    RoomService roomService = RoomService.getInstance();
    GuestService guestService = new GuestService();

    private final static ReservationRepository instance = new ReservationRepository();
    private ReservationRepository(){

    }

    public Reservation createNewReservation(Room room, Guest guest, LocalDateTime from, LocalDateTime to) {

        Reservation res = new Reservation(findNewId(), room, guest, from, to);
        this.reservations.add(res);
        return res;
    }

    private void addExistingReservation(int id, Room room, Guest guest, LocalDateTime from, LocalDateTime to) {

        Reservation newReservation = new Reservation(id, room, guest, from, to);
        reservations.add(newReservation);
    }

    private int findNewId() {

        int max = 0;
        for (Reservation reservation : this.reservations) {
            if (reservation.getId() > max) {
                max = reservation.getId();
            }
        }
        return max + 1;
    }

    public void saveAll() {
        String name = "reservations.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);
        StringBuilder stringBuilder = new StringBuilder();

        for (Reservation reservation : this.reservations) {
            stringBuilder.append(reservation.toCSV());
        }

        try {
            Files.writeString(file, stringBuilder.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOCustomException(file.toString(), "Saving reservations' file error", "Reservation data");
        }
    }

    public void readAll() {
        String name = "reservations.csv";
        Path file = Paths.get(Properties.DATA_DIRECTORY.toString(), name);

        if (!Files.exists(file)) {
            return;
        }

        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] reservationsAsString = data.split(System.getProperty("line.separator"));

            for (String reservationAsString : reservationsAsString) {
                String[] reservationData = reservationAsString.split(",");

                if (reservationData[0] == null || reservationData[0].trim().isEmpty()){
                    continue;
                }

                int id = Integer.parseInt(reservationData[0]);
                int roomID = Integer.parseInt(reservationData[1]);
                int guestID = Integer.parseInt(reservationData[2]);
                String fromAsString = reservationData[3];
                String toAsString = reservationData[4];

                addExistingReservation(id, this.roomService.getRoomByID(roomID), this.guestService.getGuestByID(guestID), LocalDateTime.parse(fromAsString), LocalDateTime.parse(toAsString));
            }

        } catch (IOException e) {
            throw new IOCustomException(file.toString(), "Reading file error", "Guest data");
        }
    }


    public List<Reservation> getAll() {
        return this.reservations;
    }

    public static ReservationRepository getInstance() {
        return instance;
    }
}
