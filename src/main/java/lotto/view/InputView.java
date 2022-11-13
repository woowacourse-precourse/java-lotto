package lotto.view;

import handler.InputHandler;

import java.util.List;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
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
