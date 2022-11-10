package lotto.utils.Advice;

public class BonusValidator {

    private static final String BONUS_REG_EXP = "\\d{1,2}";

    private BonusValidator(){}

    public static void validateBonusNumber(String bonus) {
        checkBonusSizeAndConsistNumber(bonus);
    }

    private static void checkBonusSizeAndConsistNumber(String bonus) {
        if (!bonus.matches(BONUS_REG_EXP)) {
            throw new IllegalArgumentException();
        }
    }
}
