package lotto;

public class LuckyBonus {
    public static int luckyBonus;

    public LuckyBonus(String inputLuckyBonus) {
        validateLength(inputLuckyBonus);
        validateInteger(inputLuckyBonus);
        int tempLuckyBonus = convertBonusType(inputLuckyBonus);
        validateBonusInclude(tempLuckyBonus);
    }

    private void validateLength(String inputLuckyBonus) {
        if (inputLuckyBonus.length() != 1) {
            throw new IllegalArgumentException(GameMessage.BONUS_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateInteger(String inputLuckyBonus) {
        if (!Character.isDigit(inputLuckyBonus.charAt(0))) {
            throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateBonusInclude(int tempLuckyBonus) {
        if (LuckySix.luckySix.isIncludeBonus(tempLuckyBonus)) {
            throw new IllegalArgumentException(GameMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    private int convertBonusType(String luckyBonusInput) {
        return Integer.parseInt(luckyBonusInput);
    }
}
