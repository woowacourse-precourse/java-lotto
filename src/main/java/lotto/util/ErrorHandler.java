package lotto.util;

import lotto.game.view.Console;

public class ErrorHandler {
    public static void throwException(ErrorMessage errorMessage) {
        Console.Out.printError(errorMessage);
        throw new IllegalArgumentException();
    }
}
