package lotto.model;

import lotto.model.enums.ErrorMessage;

public class LuckyBonus {
    public int luckyBonus;

    public LuckyBonus(String inputLuckyBonus, Lotto luckySix) {
        validateBonusDigit(inputLuckyBonus);
        int luckyBonus = convertBonusType(inputLuckyBonus);
        validateBonusRange(luckyBonus);
        validateBonusInclude(luckyBonus, luckySix);
        this.luckyBonus = luckyBonus;
    }

    private void validateBonusDigit(String inputLuckyBonus) {
        for (int index = 0; index < inputLuckyBonus.length(); index++) {
            if (!Character.isDigit(inputLuckyBonus.charAt(index))) {
                throw new IllegalArgumentException(ErrorMessage.DIGIT_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void validateBonusRange(int luckyBonus) {
        if (luckyBonus < 1 || luckyBonus > 45) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateBonusInclude(int tempLuckyBonus, Lotto luckySix) {
        if (luckySix.isIncludeBonus(tempLuckyBonus)) {
            throw new IllegalAccessError(ErrorMessage.SIX_CONTAIN_BONUS_ERROR_MESSAGE.getMessage());
        }
    }

    private int convertBonusType(String luckyBonusInput) {
        return Integer.parseInt(luckyBonusInput);
    }
}
