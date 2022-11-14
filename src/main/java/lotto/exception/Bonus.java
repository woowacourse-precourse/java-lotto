package lotto.exception;

import java.util.regex.Pattern;

public class Bonus extends CommonException {

    public static void checkException(String bonus) {
        checkNumberCount(bonus);
        checkInteger(bonus);
        checkNumberRange(Integer.parseInt(bonus));
    }

    private static void checkNumberCount(String bonus) {
        String pattern = "^\\d*\\D+\\d+$";
        if (Pattern.matches(pattern, bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_ONE.getMessage());
        }
    }
}
