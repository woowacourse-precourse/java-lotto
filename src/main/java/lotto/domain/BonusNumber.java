package lotto.domain;

public class BonusNumber {
    private static final String ERROR_NUMBER_RANGE = "로또 번호는 1부터 45 사이어야 합니다.";
    private static final String ERROR_IN_LOTTO = "보너스 번호는 로또 당첨 번호와 중복되지 않아야 합니다.";

    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber, Lotto lotto) {
        validateBonusNumber(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber, Lotto lotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_IN_LOTTO);
        }
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
