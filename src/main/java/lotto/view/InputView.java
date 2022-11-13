package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {}

    public InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();

        Validator.validatePurchaseAmount(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }
}
