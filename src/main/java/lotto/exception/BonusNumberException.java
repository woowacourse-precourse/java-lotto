package lotto.exception;

public class BonusNumberException {

    public static void checkBonusNumber(String bonusNumberInput) {
        CommonInputException.checkCommonInput(bonusNumberInput, "보너스 번호를");
    }
}
