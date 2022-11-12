package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class UserOutput {
    private static final String OUTPUT_BUY_LOTTOS = " 개를 구매했습니다.";

    public static void outputBuyLottos(Lottos lottos) {
        System.out.println("\n" + lottos.getNumberOfLottos().toString() + OUTPUT_BUY_LOTTOS);

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto().toString());
        }

        System.out.println();
    }
}
