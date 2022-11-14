package lotto;

public class LottoComparator {
    public static ComparisonToWinningNumberResult compare(Lotto generatedLotto, WinningNumber winningNumber) {
        int matchCount = (int) winningNumber.number.getNumbers().stream()
                .filter(number -> generatedLotto.getNumbers().contains(number))
                .count();
        boolean isBonusMatched = generatedLotto.getNumbers().contains(winningNumber.bonusNumber);
        return new ComparisonToWinningNumberResult(matchCount, isBonusMatched);
    }
}
