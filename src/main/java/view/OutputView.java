package view;

import model.EarningsRate;
import model.Lotto;
import model.Lottos;
import model.Win;
import model.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String LOTTOS_COUNT = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator();
    public static final String MATCH_COUNT = "%d개 일치";
    public static final String BONUS_BALL = ", 보너스 볼 일치";
    public static final String WINNING_AMOUNT_AND_COUNT = " (%,d원) - %d개" + System.lineSeparator();
    public static final String EARNINGS_RATE = "총 수익률은 %.1f%%입니다.";

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

        Win[] wins = Win.values();
        for (int ranking = wins.length - 1; ranking >= 0; ranking--) {
            Win win = wins[ranking];

            result.append(String.format(MATCH_COUNT, win.getMatchCount()));
            if (win.isBonusBall()) {
                result.append(BONUS_BALL);
            }
            result.append(String.format(WINNING_AMOUNT_AND_COUNT,
                    win.getWinningAmount(), winningResult.getCount(win)));
        }

        return result.toString();
    }

    public static void printEarningsRate(EarningsRate earningsRate) {
        System.out.println(String.format(EARNINGS_RATE, earningsRate.getEarningRate()));
    }
}
