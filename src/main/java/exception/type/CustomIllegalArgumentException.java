package exception.type;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public static final String PREFIX_ERROR = "[ERROR] ";
    private String message;

    public CustomIllegalArgumentException(String message) {
        this.message = message;
        //리팩토링 필요.
        System.out.println(PREFIX_ERROR + message);
    }
}
