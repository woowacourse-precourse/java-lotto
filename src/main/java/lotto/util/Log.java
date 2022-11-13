package lotto.util;

public class Log {

    public static void error(String message) {
        System.out.println(LogLevel.ERROR.getLevel() + message);
    }

    public static void warning(String message) {
        System.out.println(LogLevel.WARNING.getLevel() + message);
    }

    public static void info(String message) {
        System.out.println(LogLevel.INFO.getLevel() + message);
    }

    public static void debug(String message) {
        System.out.println(LogLevel.DEBUG.getLevel() + message);
    }

    public static void trace(String message) {
        System.out.println(LogLevel.TRACE.getLevel() + message);
    }
}
