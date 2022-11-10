package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;

public class InputUi {

    public static int readPurchaseAmount() {
        String amountInput = Console.readLine();
        InputValidator.validateIsNumber(amountInput);

        int purchaseAmount = Integer.valueOf(amountInput);
        InputValidator.validateLottoPurchaseNumber(purchaseAmount);

        return purchaseAmount;
    }
}
