package lotto.exception;

public class InputExceptionHandler {

    public static void handleEmptyInputException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Input is empty.");
        }
    }

    public static void handleNotNumberOrCommaException(String input) {
        input = input.replaceAll("[0-9]", "");
        input = input.replaceAll(",", "");

        if (!input.isEmpty()) {
            throw new IllegalArgumentException(
                    "[ERROR] Input contains other character(s), including space.");
        }
    }

    public static void handleWinningNumbersInputFormatException(String winningNumbers) {
        if (!winningNumbers.matches("^([0-9]+[,])+[0-9]+$")) {
            throw new IllegalArgumentException(
                    "[ERROR] Input does not match the winning number format.");
        }
    }

    public static void handleNotOneNumberException(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] Input is not ONE number.");
        }
    }

    public static void handleCommonExceptions(String input) {
        handleEmptyInputException(input);
        handleNotNumberOrCommaException(input);
    }

    public static void handleWinningNumbersExceptions(String input) {
        handleCommonExceptions(input);

        handleWinningNumbersInputFormatException(input);
    }

    public static void handleOneNumberExceptions(String input) {
        handleCommonExceptions(input);

        handleNotOneNumberException(input);
    }
}
