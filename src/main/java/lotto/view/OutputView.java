package lotto.view;

import static lotto.domain.WinnerStatistics.BLANK;
import static lotto.domain.WinnerStatistics.FIFTH_PLACE;
import static lotto.domain.WinnerStatistics.FIRST_PLACE;
import static lotto.domain.WinnerStatistics.FOURTH_PLACE;
import static lotto.domain.WinnerStatistics.SECOND_PLACE;
import static lotto.domain.WinnerStatistics.THIRD_PLACE;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String STATISTICS_MESSAGE = "당첨 통계";
    public static final String STATISTICS_LINE = "---";
    public static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - ";
    public static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - ";
    public static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - ";
    public static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    public static final String COUNT_MESSAGE = "개";


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
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
