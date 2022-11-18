package lotto.view;

import static lotto.constants.ConsoleConstants.LOTTO_COUNT;
import static lotto.constants.ConsoleConstants.PRIZE_RESULT;
import static lotto.constants.ConsoleConstants.PRIZE_STAT;
import static lotto.constants.ConsoleConstants.PROFIT;
import static lotto.constants.ConsoleConstants.SECOND_PRIZE_RESULT;
import static lotto.constants.ConsoleConstants.SPLIT_LINE;

import java.util.List;
import java.util.Map;
import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.Result;

public class OutputView {
    public static void printLottos(int lottoCount, List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT, lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Result result) {
        printGameResult(result);
        printWinningAmount(result);
    }



    private static void printGameResult(Result result) {
        System.out.println(PRIZE_STAT);
        System.out.println(SPLIT_LINE);

        Map<Rank, Integer> rankInfo = result.sortedRankInfo();
        rankInfo.remove(Rank.NONE);

        for (Rank rank : rankInfo.keySet()) {
            System.out.printf(PRIZE_RESULT, rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            if (rank == Rank.SECOND) {
                System.out.printf(SECOND_PRIZE_RESULT, rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            }
        }
    }

    private static void printWinningAmount(Result result) {
        System.out.printf(PROFIT, result.getWinningAmount());
    }
}
