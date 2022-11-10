package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.LottoText;

public class LottoShop {
    private final Print print = new Print();

    private final Convert convert = new Convert();

    public void simulate() {
        int purchasePrice = inputPurchasePrice();
    }

    public int inputPurchasePrice() {
        print.out(LottoText.REQUEST_PURCHASE_PRICE);
        String input = Console.readLine();
        return convert.toPurchasePrice(input);
    }
}
