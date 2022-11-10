package lotto.exception;

public class BonusNumberException {

    private static final String NUMBER_REGEX = "[0-9]+";

    public static void checkBonusNumber(String bonusNumberInput) {
        CommonInputException.checkCommonInput(bonusNumberInput, "보너스 번호를");
        checkBonusNumberDigit(bonusNumberInput);
    }

    public static void checkBonusNumberDigit(String bonusNumber) {
        if (!bonusNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
        }
    }
}
