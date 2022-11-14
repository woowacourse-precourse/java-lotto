package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int getPurchaseAmount(){
        String purchaseAmountInput = Console.readLine();
        int purchaseAmount = Integer.valueOf(purchaseAmountInput);
        return purchaseAmount;
    }
}
