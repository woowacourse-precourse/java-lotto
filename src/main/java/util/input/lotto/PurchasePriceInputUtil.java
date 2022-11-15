package util.input.lotto;

import camp.nextstep.edu.missionutils.Console;

public class PurchasePriceInputUtil {
    public static int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");

        String purchasePrice = Console.readLine().trim();

        return Integer.parseInt(purchasePrice);
    }
}
