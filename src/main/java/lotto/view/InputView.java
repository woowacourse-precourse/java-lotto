package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        String purchaseAmountString = Console.readLine();
        return purchaseAmountString;
    }
}
