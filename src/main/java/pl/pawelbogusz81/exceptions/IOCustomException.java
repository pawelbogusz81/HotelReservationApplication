package pl.pawelbogusz81.exceptions;


public class IOCustomException extends ReservationCustomException {

    private final int code = 103;

    public IOCustomException(String fileName, String operationName,String message) {

        super (String.format("Plik błędu: %s. Niedozwolona operacja: %s (%s)", fileName, operationName, message));
    }

    public int getCode() {
        return code;
    }
}
