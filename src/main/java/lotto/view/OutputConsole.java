package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningStatistics;

import java.util.List;

import static lotto.view.ConsoleMessage.*;

public class OutputConsole {
    public OutputConsole() {

    }

    public static void printOrderHistory(List<Lotto> lottos) {
        System.out.printf(ORDER_HISTORY_HEADER, lottos.size());
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(STATISTICS_HEADER);
        System.out.printf(FIFTH_MESSAGE, winningStatistics.getCountEachResult().get(Result.FIFTH));
        System.out.printf(FOURTH_MESSAGE, winningStatistics.getCountEachResult().get(Result.FOURTH));
        System.out.printf(THIRD_MESSAGE, winningStatistics.getCountEachResult().get(Result.THIRD));
        System.out.printf(SECOND_MESSAGE, winningStatistics.getCountEachResult().get(Result.SECOND));
        System.out.printf(FIRST_MESSAGE, winningStatistics.getCountEachResult().get(Result.FIRST));
        System.out.printf(PRINT_YIELD, winningStatistics.getYield());
    }
}
