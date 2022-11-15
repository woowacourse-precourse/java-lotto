package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.result.HitResult;
import lotto.domain.result.Rank;

public class Output {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String PURCHASE_COUNT_NOTIFICATION = "\n%d개를 구매했습니다.\n";
    private static final String EARNINGS_RATE_NOTIFICATION = "총 수익률은 %.1f%%입니다.";
    private static final String WINNING_WITHOUT_BONUS = "%d개 일치 (%,d원) - %d개\n";
    private static final String WINNING_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printLottoGroup(LottoGroup lottoGroup) {
        List<Lotto> lottteries = lottoGroup.getLottoGroup();
        for (Lotto lotto : lottteries) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatistics(HitResult result) {
        Map<Rank, Integer> matchResult = result.getHitResultExceptNone();
        System.out.println(WINNING_STATISTICS);
        matchResult.forEach((key, value) -> printMatchResult(matchResult, key));
    }

    private static void printMatchResult(Map<Rank, Integer> matchResult, Rank key) {
        if (!key.hasBonusNumber()) {
            System.out.printf(WINNING_WITHOUT_BONUS, key.getHitCount(), key.getPrize(),
                    matchResult.get(Rank.getRank(key.getHitCount(), false)));
        }
        if (key.hasBonusNumber()) {
            System.out.printf(WINNING_WITH_BONUS, key.getHitCount(), key.getPrize(),
                    matchResult.get(Rank.getRank(key.getHitCount(), true)));
        }
    }

    public static void purchaseCountNotification(int purchaseCount) {
        System.out.printf(PURCHASE_COUNT_NOTIFICATION, purchaseCount);
    }

    public static void earningsRateNotification(double earningsRate) {
        System.out.printf(EARNINGS_RATE_NOTIFICATION, earningsRate);
    }
}
