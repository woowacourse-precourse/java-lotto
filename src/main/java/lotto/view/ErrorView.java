package lotto.view;

public class ErrorView {

    public static String getErrorMessage(IllegalArgumentException exception) {
        String message = String.format("[ERROR] %s", exception.getMessage());
        return message;
    }
}
