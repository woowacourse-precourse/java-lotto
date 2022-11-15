package view;

import model.EarningsRate;
import model.Lotto;
import model.Lottos;
import model.Win;
import model.WinningResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static constant.Config.NEW_LINE;

public class OutputView {
    public static final String LOTTOS_COUNT = NEW_LINE + "%d개를 구매했습니다." + NEW_LINE;
    public static final String WINNING_STATISTICS = NEW_LINE + "당첨 통계" + NEW_LINE + "---" + NEW_LINE;
    public static final String RANK = "%d개 일치%s (%,d원) - %d개" + NEW_LINE;
    public static final String CONTAINS_BONUS_BALL = ", 보너스 볼 일치";
    public static final String EXCEPT_BONUS_BALL = "";
    public static final String EARNINGS_RATE = "총 수익률은 %,.1f%%입니다." + NEW_LINE;

    private OutputView() {

    }

    public static void printLottos(Lottos inputLottos) {
        List<Lotto> lottos = inputLottos.getLottos();
        System.out.printf(LOTTOS_COUNT, lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.print(getResultMessage(winningResult));
    }

    private static String getResultMessage(WinningResult winningResult) {
        StringBuilder result = new StringBuilder();
        result.append(WINNING_STATISTICS);

        List<Win> reverseWins = Win.getReverseWins();

        for (Win win : reverseWins) {
            String bonusBallMatch = isBonusBallMatch(win);

            result.append(String.format(RANK, win.getMatchCount(), bonusBallMatch,
                    win.getWinningAmount(), winningResult.getCount(win)));
        }
        return result.toString();
    }

    private static String isBonusBallMatch(Win win) {
        if (win.isBonusBall()) {
            return CONTAINS_BONUS_BALL;
        }
        return EXCEPT_BONUS_BALL;
    }

    public static void printEarningsRate(EarningsRate earningsRate) {
        System.out.printf(EARNINGS_RATE, earningsRate.getEarningRate());
    }
}
