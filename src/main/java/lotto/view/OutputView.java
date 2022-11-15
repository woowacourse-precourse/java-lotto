package lotto.view;

import static lotto.constant.Constants.OutputMessage.DIVISION_LINE;
import static lotto.constant.Constants.OutputMessage.LOTTO_QUANTITY;
import static lotto.constant.Constants.OutputMessage.MATCH_BONUS_BALL;
import static lotto.constant.Constants.OutputMessage.MATCH_NUMBERS;
import static lotto.constant.Constants.OutputMessage.PRIZE;
import static lotto.constant.Constants.OutputMessage.TOTAL_YIELD;
import static lotto.constant.Constants.OutputMessage.WINNING_STATISTICS;
import static lotto.constant.Constants.OutputMessage.WON_LOTTOS_COUNT;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class OutputView {
    public static final String PRIZE_PATTERN = "###,###";
    public static final String YILED_PATTERN = "###,###.0";

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_QUANTITY, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION_LINE);
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.BANG)) {
                continue;
            }
            System.out.println(statisticsAtRank(winningStatistics, rank));
        }
    }

    public static void printYield(Money money, WinningStatistics winningStatistics) {
        double yield = money.calculateYield(winningStatistics.calculateTotalPrize());
        System.out.printf(TOTAL_YIELD, formatNumber(yield, YILED_PATTERN));
    }

    private static String statisticsAtRank(WinningStatistics winningStatistics, Rank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(MATCH_NUMBERS, rank.getSameNumbersCount()));
        if (rank.hasBonusNumber()) {
            sb.append(MATCH_BONUS_BALL);
        }
        sb.append(String.format(PRIZE, formatNumber(rank.getPrize(), PRIZE_PATTERN)))
                .append(String.format(WON_LOTTOS_COUNT, winningStatistics.countWonLottosByRank(rank)));
        return sb.toString();
    }

    private static String formatNumber(Number number, String pattern) {
        DecimalFormat formatter = new DecimalFormat(pattern);
        return formatter.format(number);
    }
}
