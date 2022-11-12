package lotto.view;

import static lotto.constant.Rank.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.constant.Rank.FIVE_MATCHES_WITH_BONUS;
import static lotto.constant.Rank.FOUR_MATCHES;
import static lotto.constant.Rank.SIX_MATCHES;
import static lotto.constant.Rank.THREE_MATCHES;

import java.util.List;

public class Output {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String PURCHASE_COUNT_NOTIFICATION = "\n%d개를 구매했습니다.\n";
    private static final String EARNINGS_RATE_NOTIFICATION = "총 수익률은 %.1f%%입니다.";

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printWinningStatistics(List<Integer> matchResults) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCHES.getRank(matchResults));
        System.out.println(FOUR_MATCHES.getRank(matchResults));
        System.out.println(FIVE_MATCHES_WITHOUT_BONUS.getRank(matchResults));
        System.out.println(FIVE_MATCHES_WITH_BONUS.getRank(matchResults));
        System.out.println(SIX_MATCHES.getRank(matchResults));
    }

    public static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        System.out.println(lotteryNumbers.toString());
    }

    public static void purchaseCountNotification(int purchaseCount) {
        System.out.printf(PURCHASE_COUNT_NOTIFICATION, purchaseCount);
    }

    public static void earningsRateNotification(double earningsRate) {
        System.out.printf(EARNINGS_RATE_NOTIFICATION, earningsRate);
    }
}
