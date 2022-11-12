package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_PHRASE = "개를 구매했습니다.";

    public static void showLottoNumber(List<Lotto> lottos) {
        System.out.println(Integer.toString(lottos.size()).concat(PURCHASE_PHRASE));

        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }
}
