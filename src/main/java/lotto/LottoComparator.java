package lotto;

import java.util.Map;

public class LottoComparator {
    public static ComparisonToWinningNumberResult compare(Lotto generatedLotto, WinningNumber winningNumber) {
        int matchCount = (int) winningNumber.mainNumbers.getNumbers().stream()
                .filter(number -> generatedLotto.getNumbers().contains(number))
                .count();
        boolean isBonusMatched = generatedLotto.getNumbers().contains(winningNumber.bonusNumber);
        return new ComparisonToWinningNumberResult(matchCount, isBonusMatched);
    }

    public static LottoPrize compareAndCountMatchLotto(Lotto lotto,
                                                 WinningNumber winningNumber) {
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        LottoPrize prizeOfResult = LottoPrize.of(result);
        return prizeOfResult;
    }

}
