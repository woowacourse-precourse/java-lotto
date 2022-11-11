package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.WinningNumber.*;

public class CheckLotto {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public CheckLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningNumber, Integer> match(List<Lotto> lottery) {
        Map<WinningNumber, Integer> amountCount = initMatchCount();

        for (Lotto lotto : lottery) {
            long winningCount = 0L;
            long bonusCount = 0L;

            winningCount += getWinningCount(lotto);
            bonusCount += getBonusCount(lotto);

            WinningNumber.count(amountCount, Long.valueOf(winningCount).intValue(), Long.valueOf(bonusCount).intValue());
        }
        return amountCount;
    }

    private Map<WinningNumber, Integer> initMatchCount() {
        Map<WinningNumber, Integer> amountCount = new HashMap<>();
        List<WinningNumber> amounts = List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, FIVE_AND_BONUS_BALL_MATCHES, SIX_MATCHES);

        for (WinningNumber amount : amounts) {
            amountCount.put(amount, 0);
        }

        return amountCount;
    }

    public long getWinningCount(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    public long getBonusCount(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(number -> number.equals(bonusNumber))
                .count();
    }
}
