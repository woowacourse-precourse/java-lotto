package lotto.domain;

public class BonusNumber {
    private static final String ERROR_NUMBER_RANGE = "로또 번호는 1부터 45 사이어야 합니다.";

    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }
}
