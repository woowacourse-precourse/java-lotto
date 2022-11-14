package view;

import model.EarningsRate;
import model.Lotto;
import model.Lottos;
import model.Win;
import model.WinningResult;

import java.util.List;

public class OutputView {
    public static final String LOTTOS_COUNT = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator();
    public static final String RANK = "%d개 일치%s (%,d원) - %d개" + System.lineSeparator();
    public static final String CONTAINS_BONUS_BALL = ", 보너스 볼 일치";
    public static final String EXCEPT_BONUS_BALL = "";
    public static final String EARNINGS_RATE = "총 수익률은 %,.1f%%입니다." + System.lineSeparator();

    private OutputView() {

    }

    public static void printLottos(Lottos inputLottos) {
        List<Lotto> lottos = inputLottos.getLottos();
        System.out.println(lottos.size() + LOTTOS_COUNT);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println(getResultMessage(winningResult));
    }

    private static String getResultMessage(WinningResult winningResult) {
        StringBuilder result = new StringBuilder();
        result.append(WINNING_STATISTICS);

        for (Win win : Win.values()) {
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
