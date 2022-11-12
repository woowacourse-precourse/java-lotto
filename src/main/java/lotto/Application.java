package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = askPurchaseAmount();
        int lottoCount = Purchase.getLottoCount(purchaseAmount);
        System.out.println(lottoCount);
    }

    private static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
