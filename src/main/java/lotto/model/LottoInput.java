package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class LottoInput {
    private final InputValidator inputValidator = new InputValidator();

    public String inputLottoGame() {
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = inputLottoGame();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        inputValidator.validatePurchaseAmount(purchaseAmount);
    }
}
