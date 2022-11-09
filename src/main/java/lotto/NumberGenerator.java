package lotto;

import camp.nextstep.edu.missionutils.Console;

public class NumberGenerator {

    public NumberGenerator() {
    }

    public int enterPurchasePrice() {
        String purchasePrice = Console.readLine();
        return Integer.parseInt(purchasePrice);
    }
}
