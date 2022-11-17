package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.utils.ErrorMessage;
import lotto.utils.Numbers;

import java.util.Arrays;

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

    public void informPurchaseCount(Lottos lottos) {
        int count = lottos.countTotal();
        System.out.println(String.format(INFORM_PURCHASE_COUNT, count));
    }

    public void printIssuedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printWinningOverview(Lottos lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = lottos.countNumberOfWins(winningLotto);
        double profit = lottoResult.calculateProfitRate();

        printOverViewIntro();
        printTotalResults(lottoResult);
        printProfit(profit);
    }

    private void printOverViewIntro() {
        System.out.println(WINNING_OVERVIEW_INTRO);
        System.out.println(DIVIDING_LINE);
    }

    private void printTotalResults(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .filter(Rank::win)
                .forEach(rank -> printResult(lottoResult, rank));
    }

    private void printResult(LottoResult lottoResult, Rank rank) {
        System.out.println(getResultMessage(lottoResult, rank));
    }

    private String getResultMessage(LottoResult lottoResult, Rank rank) {
        StringBuilder message = new StringBuilder();

        message.append(String.format(INFORM_MATCHING_COUNT, rank.getCountOfMatches()));
        if (rank.equals(Rank.SECOND)) {
            message.append(INFORM_SAME_BONUS_NUMBER);
        }
        message.append(String.format(INFORM_WINNING_AMOUNT, Numbers.getNumbersWithComma(rank.getWinningMoney())))
                .append(STATISTIC_SEPARATOR)
                .append(String.format(INFORM_WINNING_COUNTS, lottoResult.winningCountsOf(rank)));

        return message.toString();
    }

    private void printProfit(double profit) {
        System.out.printf(INFORM_PROFIT, profit);
    }

    public static void printErrorMessage(IllegalArgumentException error) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(error.getMessage());
    }
}
