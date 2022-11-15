package lotto.util;

public class Logger {
    private static final String ERROR_LOG_PREFIX = "[ERROR] ";

    public static void printError(String errorMessage) {
        System.out.println(ERROR_LOG_PREFIX + errorMessage);
    }
}
