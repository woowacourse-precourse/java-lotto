package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.domain.Buyer;

public class LottoProgram {

    private static Buyer buyer = new Buyer();
    public static void init() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmout = Console.readLine();
        String purchaseRegex = "^[1-9]*000$";
        if (!Pattern.matches(purchaseRegex, purchaseAmout)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        int purchaseAmoutCash = Integer.parseInt(purchaseAmout);

        buyer.setTotalPurchaseAmout(purchaseAmoutCash);

        int numbersOfLotto = purchaseAmoutCash / 1000;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        System.out.println(buyer.getLottoPurchasedCount() + "개를 구매했습니다.");
    }
}
