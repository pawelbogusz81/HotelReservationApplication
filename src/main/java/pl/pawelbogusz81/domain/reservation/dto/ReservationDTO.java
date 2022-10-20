package pl.pawelbogusz81.domain.reservation.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private int id;
    private String roomInfo;
    private String guestInfo;
    private LocalDateTime from;
    private LocalDateTime to;

    public ReservationDTO(int id, String roomInfo, String guestName, LocalDateTime from, LocalDateTime to) {
        this.id = id;
        this.roomInfo = roomInfo;
        this.guestInfo = guestName;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public String getGuestInfo() {
        return guestInfo;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
