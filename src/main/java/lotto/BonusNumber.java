package lotto;

import static lotto.Money.BLANK;

public class BonusNumber {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 2;

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = validate(bonusNumber);
    }

    private int validate(String bonusNumber) {
        validateBlank(bonusNumber);
        validateBonusNumberLength(bonusNumber);
        return validateInputBonusNumberType(bonusNumber);
    }

    private void validateBlank(String bonusNumber) {
        if (bonusNumber.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 숫자가 아닙니다.");
        }
    }

    private void validateBonusNumberLength(String bonusNumber) {
        if (bonusNumber.length() < MIN_LENGTH || bonusNumber.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 숫자가 올바르지 않습니다.");
        }
    }

    private int validateInputBonusNumberType(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 숫자 타입이 올바르지 않습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}