package lotto.view;

import static lotto.domain.WinnerStatistics.BLANK;
import static lotto.domain.WinnerStatistics.FIFTH_PLACE;
import static lotto.domain.WinnerStatistics.FIRST_PLACE;
import static lotto.domain.WinnerStatistics.FOURTH_PLACE;
import static lotto.domain.WinnerStatistics.SECOND_PLACE;
import static lotto.domain.WinnerStatistics.THIRD_PLACE;
import static lotto.utils.Constant.COUNT_MESSAGE;
import static lotto.utils.Constant.FIFTH_PLACE_MESSAGE;
import static lotto.utils.Constant.FIRST_PLACE_MESSAGE;
import static lotto.utils.Constant.FOURTH_PLACE_MESSAGE;
import static lotto.utils.Constant.PROFIT_RATE_MESSAGE;
import static lotto.utils.Constant.PURCHASE_MESSAGE;
import static lotto.utils.Constant.SECOND_PLACE_MESSAGE;
import static lotto.utils.Constant.STATISTICS_LINE;
import static lotto.utils.Constant.STATISTICS_MESSAGE;
import static lotto.utils.Constant.THIRD_PLACE_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottoPurchaseNumber(int purchaseNumbers) {
        System.out.println(purchaseNumbers + PURCHASE_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinnerStatistics(Map<Integer, Integer> winnerStatistics) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_LINE);
        System.out.println(FIFTH_PLACE_MESSAGE
                + winnerStatistics.getOrDefault(FIFTH_PLACE, BLANK) + COUNT_MESSAGE);
        System.out.println(FOURTH_PLACE_MESSAGE
                + winnerStatistics.getOrDefault(FOURTH_PLACE, BLANK) + COUNT_MESSAGE);
        System.out.println(THIRD_PLACE_MESSAGE
                + winnerStatistics.getOrDefault(THIRD_PLACE, BLANK) + COUNT_MESSAGE);
        System.out.println(SECOND_PLACE_MESSAGE
                + winnerStatistics.getOrDefault(SECOND_PLACE, BLANK) + COUNT_MESSAGE);
        System.out.println(FIRST_PLACE_MESSAGE
                + winnerStatistics.getOrDefault(FIRST_PLACE, BLANK) + COUNT_MESSAGE);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
