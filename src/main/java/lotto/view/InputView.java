package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.PurchasePriceInputValidation;

public class InputView {
    OutputView outputView = new OutputView();

    public int userInputPurchasePrice() {
        outputView.printPurchasePriceMessage();
        String inputPurchasePrice = Console.readLine();

        PurchasePriceInputValidation purchasePriceInputValidation = new PurchasePriceInputValidation();
        purchasePriceInputValidation.validate(inputPurchasePrice);

        int purchasePrice = Integer.parseInt(inputPurchasePrice);
        return purchasePrice;
    }
}
