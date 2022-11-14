package lotto;

import static lotto.Money.BLANK;

public class BonusNumber {

    private static final int DEFAULT_LENGTH = 1;

    private final int inputBonusNumber;

    public BonusNumber(String inputBonusNumber) {
        this.inputBonusNumber = validate(inputBonusNumber);
    }

    private int validate(String inputBonusNumber) {
        validateBlank(inputBonusNumber);
        validateBonusNumberLength(inputBonusNumber);
        return validateInputBonusNumberType(inputBonusNumber);
    }

    private void validateBlank(String inputBonusNumber) {
        if (inputBonusNumber.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 숫자가 아닙니다.");
        }
    }

    private void validateBonusNumberLength(String inputBonusNumber) {
        if (inputBonusNumber.length() != DEFAULT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 숫자 길이가 한자리가 아닙니다.");
        }
    }

    private int validateInputBonusNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 숫자 타입이 올바르지 않습니다.");
        }
    }

    public int getInputBonusNumber() {
        return inputBonusNumber;
    }

}
