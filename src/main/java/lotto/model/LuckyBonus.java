package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.validator.Validator;

public class LuckyBonus {
    public static int luckyBonus;

    public LuckyBonus(String inputLuckyBonus) {
        validateBonusDigit(inputLuckyBonus);
        int tempLuckyBonus = convertBonusType(inputLuckyBonus);
        validateBonusRange(tempLuckyBonus);
        validateBonusInclude(tempLuckyBonus);
        luckyBonus = tempLuckyBonus;
    }

    private void validateBonusDigit(String inputLuckyBonus) {
        try {
            Validator.validateDigit(inputLuckyBonus);
        } catch (IllegalArgumentException bonusDigitError){
            ErrorMessage.DIGIT_ERROR_MESSAGE.printMessage();
        }
    }

    private void validateBonusRange(int tempLuckyBonus) {
        try {
            Validator.validateBonusRange(tempLuckyBonus);
        } catch (IllegalArgumentException bonusRangeError) {
            ErrorMessage.RANGE_ERROR_MESSAGE.printMessage();
        }
    }

    private void validateBonusInclude(int tempLuckyBonus) {
        if (LuckySix.luckySix.isIncludeBonus(tempLuckyBonus)) {
            ErrorMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.printMessage();
            throw new IllegalAccessError();
        }
    }

    private int convertBonusType(String luckyBonusInput) {
        return Integer.parseInt(luckyBonusInput);
    }
}
