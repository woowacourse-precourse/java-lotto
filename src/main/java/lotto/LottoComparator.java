package lotto;

public class LottoComparator {
    public static ComparisonToWinningNumberResult compare(Lotto generatedLotto, WinningNumber winningNumber) {
        int matchCount = generatedLotto.matchCount(winningNumber.mainNumbers);
        boolean isBonusMatched = generatedLotto.contains(winningNumber.bonusNumber);

        return new ComparisonToWinningNumberResult(matchCount, isBonusMatched);
    }

    public static LottoPrize compareAndCountMatchLotto(Lotto lotto,
                                                       WinningNumber winningNumber) {
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        LottoPrize prizeOfResult = LottoPrize.of(result);
        return prizeOfResult;
    }

}
