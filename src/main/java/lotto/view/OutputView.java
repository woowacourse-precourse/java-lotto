package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Reward;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String LOTTO_RESULT_MESSAGE = "- %d개";

    public static void printPurchasedLotto(int lottoCount) {
        System.out.println(lottoCount + PURCHASE_MESSAGE);
    }

    public static void printLottoNumbers(List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getNumbers());
        }
    }
}
