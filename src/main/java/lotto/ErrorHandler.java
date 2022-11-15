package lotto;

import lotto.view.OutputView;

public class ErrorHandler {
    private ErrorHandler() {
    }

    public static void handle(String message) {
        OutputView.printErrorMessage(message);
        throw new IllegalArgumentException();
    }
}
