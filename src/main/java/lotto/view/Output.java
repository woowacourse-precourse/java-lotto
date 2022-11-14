package lotto.view;

import static lotto.domain.result.Rank.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.domain.result.Rank.FIVE_MATCHES_WITH_BONUS;
import static lotto.domain.result.Rank.FOUR_MATCHES;
import static lotto.domain.result.Rank.SIX_MATCHES;
import static lotto.domain.result.Rank.THREE_MATCHES;

import java.util.List;
import java.util.Map;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.result.Result;

public class Output {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String PURCHASE_COUNT_NOTIFICATION = "\n%d개를 구매했습니다.\n";
    private static final String EARNINGS_RATE_NOTIFICATION = "총 수익률은 %.1f%%입니다.";

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printLottoGroup(LottoGroup lottoGroup) {
        List<Lotto> lottteries = lottoGroup.getLottoGroup();
        for (Lotto lotto : lottteries) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatistics(Result result) {
        Map<Integer, Integer> matchResult = result.getResult();
        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCHES.getRank(matchResult));
        System.out.println(FOUR_MATCHES.getRank(matchResult));
        System.out.println(FIVE_MATCHES_WITHOUT_BONUS.getRank(matchResult));
        System.out.println(FIVE_MATCHES_WITH_BONUS.getRank(matchResult));
        System.out.println(SIX_MATCHES.getRank(matchResult));
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
