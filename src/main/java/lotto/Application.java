package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.PurchaseAmount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        PurchaseAmount.checkException(purchaseAmount);
        System.out.println();
        return Integer.parseInt(purchaseAmount);
    }
}
