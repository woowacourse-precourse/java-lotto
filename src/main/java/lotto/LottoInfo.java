package lotto;

public class LottoInfo {

    private final Lotto winNumbers;
    private final int bonusNumber;

    public LottoInfo(Lotto winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.NOT_UNIQUE_NUMBERS));
        }
    }
}
