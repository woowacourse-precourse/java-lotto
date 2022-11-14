package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();

    public int userInputPurchasePrice() {
        outputView.printPurchasePriceMessage();
        String inputPurchasePrice = Console.readLine();

        int purchasePrice = Integer.parseInt(inputPurchasePrice);
        return purchasePrice;
    }
}
