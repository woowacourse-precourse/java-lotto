package lotto.controller;

import lotto.constants.Number;
import lotto.exception.PurchaseAmount;
import lotto.view.Input;
import lotto.view.Output;

public class UserController {
    public static int getPurchaseAmount() {
        Output.printStartMsg();
        String input = Input.inputPurchaseAmount();
        PurchaseAmount.exceptionPurchaseAmount(input);
        int purchaseAmount = toStringPurchaseAmount(input);

        return purchaseAmount;
    }

    public static int toStringPurchaseAmount(String input) {
        int purchaseAmount = Integer.valueOf(input);
        return purchaseAmount;
    }

    public static int getPurchaseNumber(int purchaseAmount) {
        int purchaseNumber = purchaseAmount / Number.PRICE.getNumber();
        return purchaseNumber;
    }
}