package lotto;

import camp.nextstep.edu.missionutils.Console;

public class NumberGenerator {

    public NumberGenerator() {
    }

    public int calculatorLottoNumber(int purchasePrice) {
        return purchasePrice / Constant.PRICE_UNIT;
    }

    public int enterPurchasePrice() {
        String purchasePrice = Console.readLine();
        return Integer.parseInt(purchasePrice);
    }
}
