package lotto.domain;

public class WinningNumber {
    private static final String DUPLICATE_BONUS_MESSAGE = String.format(
            "[ERROR]: The bonus number was duplicated with the winning number.");
    private final Lotto numbers;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.numbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank computeRank(Lotto lottoNumbers) {
        int matchCount = numbers.computeMatchCount(lottoNumbers);
        return Rank.findRank(matchCount, lottoNumbers.contains(bonusNumber));
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_MESSAGE);
        }
    }
}