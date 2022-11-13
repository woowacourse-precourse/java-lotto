package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.utils.ErrorMessage;

import java.util.Map;

public class OutputView {
    public static final String DIVIDING_LINE = "---";
    public static final String INFORM_PURCHASE_COUNT = "%d개를 구매했습니다.";
    public static final String INFORM_PROFIT = "총 수익률은 %.1f%%입니다.";
    public static final String INFORM_FIRST_PLACE_STATISTIC = "6개 일치 (2,000,000,000원) - %d개";
    public static final String INFORM_SECOND_PLACE_STATISTIC = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String INFORM_THIRD_PLACE_STATISTIC = "5개 일치 (1,500,000원) - %d개";
    public static final String INFORM_FOURTH_PLACE_STATISTIC = "4개 일치 (50,000원) - %d개";
    public static final String INFORM_FIFTH_PLACE_STATISTIC = "3개 일치 (5,000원) - %d개";
    public static final String WINNING_STATISTIC = "당첨 통계";
    public static final String WINNING_OVERVIEW_INTRO = WINNING_STATISTIC;

    public static void informPurchaseCount(Lottos lottos) {
        int count = lottos.countTotal();
        System.out.println(String.format(INFORM_PURCHASE_COUNT, count));
    }

    public static void printIssuedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printWinningOverview(Lottos lottos, Lotto winningLotto, int bounsNumber) {
        Map<LottoResult, Integer> totalResult = lottos.getWinningCounts(winningLotto, bounsNumber);
        double profit = lottos.calculateProfit(winningLotto, bounsNumber);

        printOverViewIntro();
        printWinningCounts(totalResult);
        printProfit(profit);
    }

    private static void printProfit(double profit) {
        System.out.print(String.format(INFORM_PROFIT, profit));
    }

    private static void printWinningCounts(Map<LottoResult, Integer> winningCounts) {
        System.out.println(String.format(INFORM_FIFTH_PLACE_STATISTIC, winningCounts.get(LottoResult.FIFTH_PLACE)));
        System.out.println(String.format(INFORM_FOURTH_PLACE_STATISTIC, winningCounts.get(LottoResult.FOURTH_PLACE)));
        System.out.println(String.format(INFORM_THIRD_PLACE_STATISTIC, winningCounts.get(LottoResult.THIRD_PLACE)));
        System.out.println(String.format(INFORM_SECOND_PLACE_STATISTIC, winningCounts.get(LottoResult.SECOND_PLACE)));
        System.out.println(String.format(INFORM_FIRST_PLACE_STATISTIC, winningCounts.get(LottoResult.FIRST_PLACE)));
    }

    private static void printOverViewIntro() {
        System.out.println(WINNING_OVERVIEW_INTRO);
        System.out.println(DIVIDING_LINE);
    }

    public static void printErrorMessage(IllegalArgumentException error) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(error.getMessage());
    }
}
