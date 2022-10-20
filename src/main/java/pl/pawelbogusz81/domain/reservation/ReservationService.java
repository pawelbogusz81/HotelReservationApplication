package pl.pawelbogusz81.domain.reservation;

import pl.pawelbogusz81.domain.guest.Guest;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.room.Room;
import pl.pawelbogusz81.domain.room.RoomService;
import pl.pawelbogusz81.util.Properties;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationService {

    private final RoomService roomService = new RoomService();
    private final GuestService guestService = new GuestService();
    private final ReservationRepository repository = new ReservationRepository();

    public Reservation createReservation(LocalDate from, LocalDate to, int roomId, int guestId) throws IllegalArgumentException{

        //TODO
        Room room = this.roomService.getRoomByID(roomId);
        Guest guest = this.guestService.getGuestByID(guestId);

        LocalDateTime fromWithTime = from.atTime(Properties.HOTEL_NIGHT_START_HOUR, Properties.HOTEL_NIGHT_START_MINUTE);
        LocalDateTime toWithTime = to.atTime(Properties.HOTEL_NIGHT_END_HOUR, Properties.HOTEL_NIGHT_END_MINUTE);

        if (toWithTime.isBefore(fromWithTime)){
            throw new IllegalArgumentException();
        }

        return this.repository.createNewReservation(room, guest, fromWithTime, toWithTime);
    }

    public void readAll() { repository.readAll(); }

    public void saveAll() { repository.saveAll(); }

}
