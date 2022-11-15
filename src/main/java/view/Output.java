package view;

import lotto.Lotto;
import lotto.result.LotteryResult;
import lotto.result.Rank;
import utils.Util;

import java.util.List;

public class Output {
    private static final String BUY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_START_MESSAGE = "\n당첨 통계\n---";
    private static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개\n";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printBoughtLotteryNumber(int count) {
        System.out.printf(BUY_MESSAGE, count);
    }

    public static void printRandomLotteryNumber(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottosResult(LotteryResult result) {
        System.out.println(RESULT_START_MESSAGE);
        for (Rank rank : Rank.getWithoutDefault()) {
            System.out.printf(RESULT_RANK_MESSAGE,
                    rank.getMatchCount(), printIfSecond(rank),
                    Util.convertIntegerToMoneyFormat(rank.getPrize()), result.getRankCount(rank));
        }
    }

    private static String printIfSecond(final Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return BONUS_MESSAGE;
        }
        return " ";
    }

    public static void printProfit(float profit) {
        System.out.printf(EARNING_RATE_MESSAGE, profit);
    }

}
