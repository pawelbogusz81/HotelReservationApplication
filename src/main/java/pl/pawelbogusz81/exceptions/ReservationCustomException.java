package pl.pawelbogusz81.exceptions;

abstract public class ReservationCustomException extends RuntimeException{

    abstract public int getCode();

    public ReservationCustomException(String message) {
        super(message);
    }
}
