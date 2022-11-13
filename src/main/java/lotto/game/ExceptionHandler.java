package lotto.game;

public class ExceptionHandler {
    private static final String ERROR = "[ERROR] ";

    public static void throwException(String message) {
        System.out.println(ERROR + message);
        throw new IllegalArgumentException(ERROR + message);
    }

}
