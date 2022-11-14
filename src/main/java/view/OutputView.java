package view;

import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE = "%s개를 구매했습니다.\n";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE, lottoCount);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
