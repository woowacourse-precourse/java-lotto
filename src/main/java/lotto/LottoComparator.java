package lotto;

public class LottoComparator {
    public static ComparisonToWinningNumberResult compare(Lotto generatedLotto, WinningNumber winningNumber) {
        int matchCount = matchNumbers(generatedLotto, winningNumber);
        boolean isBonusMatched = generatedLotto.getNumbers().contains(winningNumber.bonusNumber);

        return new ComparisonToWinningNumberResult(matchCount, isBonusMatched);
    }

    private static int matchNumbers(Lotto generatedLotto, WinningNumber winningNumber) {
        return (int) winningNumber.mainNumbers.getNumbers().stream()
                .filter(number -> generatedLotto.getNumbers().contains(number))
                .count();
    }

    public static LottoPrize compareAndCountMatchLotto(Lotto lotto,
                                                       WinningNumber winningNumber) {
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        LottoPrize prizeOfResult = LottoPrize.of(result);
        return prizeOfResult;
    }

}
