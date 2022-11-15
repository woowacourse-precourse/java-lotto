package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;

import static lotto.constant.MessageConstants.*;
import java.util.List;

public class OutputView {
    public static void printPurchasedLotto(List<Lotto> lottos) {
        int lottoCount = lottos.size();
        System.out.println(ENTER+ lottoCount + PURCHASED_MESSAGE);
        lottos.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public static void showStatistic() {
        System.out.println(ENTER + WIN_STAT_MESSAGE);
        for(Statistic stat : Statistic.values()) {
            System.out.println(stat.getMessage() + stat.getCount() + COUNT);
        }
    }

    public static void showRateOfReturn(String rateOfReturn) {
        System.out.println(ROR_START_MESSAGE + rateOfReturn + END_MESSAGE);
    }
}
