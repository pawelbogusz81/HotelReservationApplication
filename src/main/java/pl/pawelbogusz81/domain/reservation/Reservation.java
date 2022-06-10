package pl.pawelbogusz81.domain.reservation;

import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.domain.room.Room;

import java.time.LocalDateTime;

public class Reservation {

    private final Room room;
    private final Guest guest;
    private final LocalDateTime from;
    private final LocalDateTime to;


    public Reservation(Room room, Guest guest, LocalDateTime from, LocalDateTime to) {
        this.room = room;
        this.guest = guest;
        this.from = from;
        this.to = to;
    }
}
