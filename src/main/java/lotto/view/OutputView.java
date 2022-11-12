package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "{0}개를 구매했습니다.";

    public static void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(MessageFormat.format(PURCHASE_LOTTO_COUNT_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}