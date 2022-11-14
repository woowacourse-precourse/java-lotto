package lotto.utils;

import lotto.domain.*;

import java.util.Map;

public final class Output {
    private static final String STATISTICS_START_MESSAGE = "당첨 통계";
    private static final String CONTOUR = "---";
    private static final String STATISTICS_NO_BONUS_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    private Output() {}

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printPurchasedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(StringParser.parseLottoToString(lotto));
        }
    }

    public static void printTotalResult(Statistics statistics, Amount amount) {
        System.out.println("\n" + STATISTICS_START_MESSAGE);
        System.out.println(CONTOUR);
        Map<Prize, Integer> statisticsResult = statistics.getStatisticsResult();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NOTHING) {
                continue;
            }
            if (prize == Prize.SECOND) {
                System.out.printf(STATISTICS_BONUS_MESSAGE, prize.getMatchCount(), prize.getReward(), statisticsResult.get(prize));
                continue;
            }
            System.out.printf(STATISTICS_NO_BONUS_MESSAGE, prize.getMatchCount(), prize.getReward(), statisticsResult.get(prize));
        }
        printTotalYield(statistics, amount);
    }

    private static void printTotalYield(Statistics statistics, Amount amount) {
        System.out.printf(YIELD_MESSAGE, statistics.calculateYiled(amount));
    }
}
