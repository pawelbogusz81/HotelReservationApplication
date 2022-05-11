public class OnlyNumberException extends RuntimeException{
    private int code = 102;

    public OnlyNumberException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
