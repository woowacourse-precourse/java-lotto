package lotto.view;

public class ErrorLog {
    private static final String PREFIX = "[ERROR] ";

    public static void printError(String message) {
        System.out.println(PREFIX + message);
    }
}
