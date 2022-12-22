package lotto.validate;

import lotto.util.Converter;

public class ValidateBonusNumber extends Validate {
    public static int validate(String bonusNumber) throws IllegalArgumentException {
        validateIsNullOrEmpty(bonusNumber);
        validateIsNumber(bonusNumber);
        validateRange(bonusNumber);

        return Converter.stringToInt(bonusNumber);
    }

    private static void validateRange(String bonusNumber) throws IllegalArgumentException {
        int number = Integer.parseInt(bonusNumber);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE +
                    MIN_NUMBER + "과 " + MAX_NUMBER + "사이의 숫자를 입력하셔야 합니다.");
        }
    }
}
