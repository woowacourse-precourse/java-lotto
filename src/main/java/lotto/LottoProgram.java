package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

        purchasedLottoSave();


    }

    private static void purchasedLottoSave() {
        int count = buyer.getLottoPurchasedCount();
        for (int lottoCount = 0; lottoCount < count; lottoCount++) {
            List<Integer> purchasedLottoNumber = new ArrayList<Integer>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottoNumber.sort(Comparator.naturalOrder());
            System.out.println(purchasedLottoNumber);
            buyer.setLottoPurchased(new Lotto(purchasedLottoNumber));
        }
    }
}
