package pl.pawelbogusz81.domain.reservation.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private int id;
    private String roomInfo;
    private String guestInfo;
    private String from;
    private String to;

    public ReservationDTO(int id, String roomInfo, String guestName, String from, String to) {
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

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
