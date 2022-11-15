package lotto.view;

public class ExceptionView {
    public static final String ERROR_PREFIX = "[ERROR]";

    public static void print(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
