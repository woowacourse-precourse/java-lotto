package lotto.winning;

import lotto.lotto.Lotto;

public class WinningResultCalculator {
    public WinningResult calculate(WinningNumber winningNumber, Lotto lotto) {
        Integer matchedCount = winningNumber.getNumbers().stream().reduce(0, (prev, wNumber) -> {
            boolean matched = lotto.getNumbers().contains(wNumber);
            if (matched) {
                prev += 1;
            }
            return prev;
        });
        boolean bonusMatched = winningNumber.getNumbers().stream().anyMatch(wNumber -> lotto.getNumbers()
                .contains(wNumber));
        return WinningResult.generate(matchedCount, bonusMatched);
    }
}
