package lotto.ui;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String INPUT_MONEY_PATTERN = "^[1-9]+[0-9]{3,8}+$";
    private static final String INPUT_WINNING_NUMBERS_PATTERN = "^[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}$";
    private static final String INPUT_BONUS_NUMBER_PATTERN = "^[0-9]*$";
    private static final int MAXIMUM_DIGITS = 9;

    public static void checkInputMoney(String inputMoneyRaw) {
        boolean isMatch = Pattern.matches(INPUT_MONEY_PATTERN, inputMoneyRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] 1000의 배수를 입력하세요. 단, 1000000000 미만의 수만 입력해주세요. (ex: 2000, 12345000)"
        );
    }

    public static void checkInputWinningNumbers(String numbersRaw) {
        boolean isMatch = Pattern.matches(INPUT_WINNING_NUMBERS_PATTERN, numbersRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] 6개 숫자를 공백 없이 \",\"로 이어 입력해주세요. (ex: 4,13,34,25,7,9)"
        );
    }

    public static void checkInputBonusNumber(String bonusNumberRaw) {
        checkIsMatchInputBonusPattern(bonusNumberRaw);
        checkIsOver9digits(bonusNumberRaw);
    }

    private static void checkIsMatchInputBonusPattern(String bonusNumberRaw) {
        boolean isMatch = Pattern.matches(INPUT_BONUS_NUMBER_PATTERN, bonusNumberRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] 문자와 공백 없이, 숫자 1개를 입력해주세요. (ex: 7)"
        );
    }

    private static void checkIsOver9digits(String bonusNumberRaw) {
        if (bonusNumberRaw.length() > MAXIMUM_DIGITS) {
            throw new IllegalArgumentException(
                    "[ERROR] 너무 큰 수를 입력했습니다."
            );
        }
    }
}
