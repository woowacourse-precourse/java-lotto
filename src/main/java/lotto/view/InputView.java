package lotto.view;

import handler.InputHandler;

import java.util.List;

public final class InputView {
    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        validateInputHandler(inputHandler);
        this.inputHandler = inputHandler;
    }

    private void validateInputHandler(InputHandler inputHandler) {
        if (inputHandler == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        String input = inputHandler.readLine();
        return InputValidator.toInt(input);
    }

    public List<Integer> getLotteryNumber() {
        String input = inputHandler.readLine();
        return InputValidator.splitToIntegers(input);
    }

    public int getBonusNumber() {
        String input = inputHandler.readLine();
        return InputValidator.toInt(input);
    }
}
