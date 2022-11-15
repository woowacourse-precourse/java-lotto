package lotto.logic;

import lotto.object.Lotto;
import lotto.object.WinningAmount;
import lotto.object.WinningHistory;
import lotto.object.WinningNumbers;
import lotto.object.WinningResult;

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

    public static WinningHistory getHistory() {
        return history;
    }

    public static void calcWinningTimes(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            Integer matchCount = calcWinning(lotto);
            WinningAmount amount = getAmount(matchCount, isBonusMatch(lotto));

            if (amount != null) {
                amount.addAmount();
            }
        }
    }

    private static Integer calcWinning(Lotto lotto) {
        Integer matchCount = 0;
        Integer lottoIndex = 0;
        Integer winningNumberIndex = 0;

        while (lottoIndex < WinningResult.MAX_MATCH && winningNumberIndex < WinningResult.MAX_MATCH) {

            if (lotto.getNumber(lottoIndex) < winningNumbers.getNumber(winningNumberIndex)) {
                lottoIndex += 1;
                continue;
            }
            if (lotto.getNumber(lottoIndex) > winningNumbers.getNumber(winningNumberIndex)) {
                winningNumberIndex += 1;
                continue;
            }
            matchCount += 1;
            lottoIndex += 1;
            winningNumberIndex += 1;

        }

        return matchCount;
    }

    private static Boolean isBonusMatch(Lotto lotto) {
        Integer number = winningNumbers.getBonusNumber();

        return lotto.getNumbers().contains(number);
    }

    private static WinningAmount getAmount(Integer matchCount, Boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return history.getAmount(-1);
        }
        return history.getAmount(matchCount);
    }
}
