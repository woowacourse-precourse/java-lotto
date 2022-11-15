package lotto.exception;

public class BonusNumberException {

    private static final String DIGIT_REGEX = "[0-9]+";
    private static final int MAX_BONUS_NUMBER = 45;
    private static final int MIN_BONUS_NUMBER = 1;
    private static final String NO_DIGIT_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자를 입력해주세요.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자로 입력해주세요.";

    public static void checkBonusNumber(String bonusNumberInput) {
        CommonInputException.checkCommonInput(bonusNumberInput);
        checkBonusNumberDigit(bonusNumberInput);
        checkBonusNumberRange(Integer.parseInt(bonusNumberInput));
    }

    public static void checkBonusNumberDigit(String bonusNumber) {
        if (!bonusNumber.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(NO_DIGIT_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
        }
    }
}
