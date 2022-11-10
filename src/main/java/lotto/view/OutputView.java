package lotto.view;

public class OutputView {

    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE, errorMessage));
    }
}
