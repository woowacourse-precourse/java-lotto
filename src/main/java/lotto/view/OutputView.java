package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.utils.ErrorMessage;
import lotto.utils.Numbers;

import java.util.Arrays;
import java.util.Map;

public class OutputView {
    public static final String DIVIDING_LINE = "---";
    public static final String INFORM_PURCHASE_COUNT = "%d개를 구매했습니다.";
    public static final String INFORM_PROFIT = "총 수익률은 %.1f%%입니다.";
    public static final String WINNING_OVERVIEW_INTRO = "당첨 통계";
    public static final String INFORM_WINNING_AMOUNT = " (%s원)";
    public static final String INFORM_WINNING_COUNTS = "%d개";
    public static final String INFORM_MATCHING_COUNT = "%d개 일치";
    public static final String INFORM_SAME_BONUS_NUMBER = ", 보너스 볼 일치";
    public static final String STATISTIC_SEPARATOR = " - ";

    public static void informPurchaseCount(Lottos lottos) {
        int count = lottos.countTotal();
        System.out.println(String.format(INFORM_PURCHASE_COUNT, count));
    }

    public static void printIssuedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printWinningOverview(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        Map<LottoResult, Integer> totalResult = lottos.getWinningCounts(winningLotto, bonusNumber);
        double profit = lottos.calculateProfit(winningLotto, bonusNumber);

        printOverViewIntro();
        printTotalResults(totalResult);
        printProfit(profit);
    }

    private static void printProfit(double profit) {
        System.out.print(String.format(INFORM_PROFIT, profit));
    }
    
    private static void printTotalResults(Map<LottoResult, Integer> winningCounts) {
        Arrays.stream(LottoResult.values())
                .filter(result -> result.win())
                .forEach(result -> printResult(winningCounts, result));
    }

    private static void printResult(Map<LottoResult, Integer> winningCounts, LottoResult result) {
        System.out.println(getResultMessage(winningCounts, result));
    }

    private static String getResultMessage(Map<LottoResult, Integer> winningCounts, LottoResult result) {
        StringBuilder message = new StringBuilder();

        message.append(String.format(INFORM_MATCHING_COUNT, result.getMatchingCount()));
        if (result.equals(LottoResult.SECOND_PLACE)) {
            message.append(INFORM_SAME_BONUS_NUMBER);
        }
        message.append(String.format(INFORM_WINNING_AMOUNT, Numbers.getNumbersWithComma(result.getAmount())))
                .append(STATISTIC_SEPARATOR)
                .append(String.format(INFORM_WINNING_COUNTS, winningCounts.get(result)));

        return message.toString();
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
