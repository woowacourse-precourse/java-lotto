package lotto.logic;

import lotto.object.Lotto;
import lotto.object.WinningAmount;
import lotto.object.WinningHistory;
import lotto.object.WinningNumbers;

import java.util.List;
import java.util.Map;

public class CalcLotto {
    private static WinningHistory history = new WinningHistory();
    private static WinningNumbers winningNumbers;

    public static void resetWinningHistory() {
        history = new WinningHistory();
    }

    public static void setWinningNumbers(WinningNumbers numbers) {
        winningNumbers = numbers;
    }

    public static Map<Integer, WinningAmount> getHistory() {
        return history.getHistory();
    }

    public static void calcWinningTimes(List<Lotto> lottos) {
        return;
    }

    private static Integer calcWinning(Lotto lotto) {
        return null;
    }
}
