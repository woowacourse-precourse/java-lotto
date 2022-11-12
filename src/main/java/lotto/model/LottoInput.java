package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.PurchaseAmountValidator;

public class LottoInput {
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public String inputLottoGame() {
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = inputLottoGame();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
    }
}
