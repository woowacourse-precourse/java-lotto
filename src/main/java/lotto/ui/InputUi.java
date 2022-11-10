package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputUi {

    public static int readPurchaseAmount(){

        String amountInput = Console.readLine();
        int purchaseAmount = Integer.valueOf(amountInput);
        return purchaseAmount;
    }
}
