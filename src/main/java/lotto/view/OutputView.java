package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void printLottoPurchaseNumber(int purchaseNumbers) {
        System.out.println(purchaseNumbers + PURCHASE_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
