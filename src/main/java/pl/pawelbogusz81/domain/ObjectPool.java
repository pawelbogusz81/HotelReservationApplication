package pl.pawelbogusz81.domain;

import pl.pawelbogusz81.domain.guest.GuestRepository;
import pl.pawelbogusz81.domain.guest.GuestService;
import pl.pawelbogusz81.domain.reservation.ReservationRepository;
import pl.pawelbogusz81.domain.reservation.ReservationService;
import pl.pawelbogusz81.domain.room.RoomRepository;
import pl.pawelbogusz81.domain.room.RoomService;

public class ObjectPool {

    private ObjectPool(){

    }


    public static GuestService getGuestService() {
        return GuestService.getInstance();
    }

    public static GuestRepository getGuestRepository() {
        return GuestRepository.getInstance();
    }

    public static RoomService getRoomService() {
        return RoomService.getInstance();
    }

    public static RoomRepository getRoomRepository() {
        return RoomRepository.getInstance();
    }

    public static ReservationService getReservationService() {
        return ReservationService.getInstance();
    }

    public static ReservationRepository getReservationRepository() {
        return ReservationRepository.getInstance();
    }
}
