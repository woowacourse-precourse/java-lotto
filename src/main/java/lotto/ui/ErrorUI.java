package lotto.ui;

public class ErrorUI {
    private static final String ERROR_HEADER = "[ERROR]";

    public void printError(String errorMessage) {
        System.out.println(String.format("%s %s", ERROR_HEADER, errorMessage));
    }
}
