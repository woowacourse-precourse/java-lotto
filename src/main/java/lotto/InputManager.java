package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private final InputValidator inputValidator = new InputValidator();
    public int inputPurchaseAmount() {
        System.out.println(ConsoleMessage.REQUEST_PURCHASE);
        String input = Console.readLine();
        inputValidator.validateInputPurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public Lotto inputWinningNumbers() {
        throw new UnsupportedOperationException();
    }

    public int inputBonusNumber() {
        throw new UnsupportedOperationException();
    }
}