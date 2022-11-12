package lotto.utils;

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    private static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void log(String message, LogType logType) {
    }

    public enum LogType {
        ERROR, WARNING, INFO;
    }
}
