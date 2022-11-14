package lotto.view;

import handler.InputHandler;

import java.util.List;

public final class InputView {
    private static final String NULL_MESSAGE = "InputHandler 가 null 입니다";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        validateInputHandler(inputHandler);
        this.inputHandler = inputHandler;
    }

    private void validateInputHandler(InputHandler inputHandler) {
        if (inputHandler == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public long inputAmount() {
        final String input = inputHandler.readLine();
        return InputValidator.toLong(input);
    }

    public List<Integer> inputLotteryNumber() {
        final String input = inputHandler.readLine();
        return InputValidator.splitToIntegers(input);
    }

    public int inputBonusNumber() {
        final String input = inputHandler.readLine();
        return InputValidator.toInt(input);
    }
}
