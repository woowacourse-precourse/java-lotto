package lotto.view;

public class ErrorView {

    public static void printErrorMessage(IllegalArgumentException exception) {
        String message = String.format("[ERROR] %s", exception.getMessage());
        System.out.println(message);
    }
}
