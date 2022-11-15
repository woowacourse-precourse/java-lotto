package lotto.utils;

import java.lang.reflect.Method;

public class Logger {
    private static final String NO_SUCH_METHOD_ERROR_MESSAGE = "존재하지 않은 로그 타입이 전달되었습니다.";

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
        Logger logger = getInstance();

        try {
            Method createLogMethod = Logger.class.getDeclaredMethod(logType.name(), String.class);
            createLogMethod.setAccessible(true);

            createLogMethod.invoke(logger, message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(NO_SUCH_METHOD_ERROR_MESSAGE);
        }
    }

    private static void ERROR(String message) {
        System.out.println("[ERROR] " + message);
    }

    private static void WARNING(String message) {
        System.out.println("[WARNING] " + message);
    }

    private static void INFO(String message) {
        System.out.println("[INFO] " + message);
    }

    public enum LogType {
        ERROR, WARNING, INFO;
    }
}
