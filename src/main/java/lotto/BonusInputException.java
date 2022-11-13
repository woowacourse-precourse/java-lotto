package lotto;

import java.util.List;

public class BonusInputException {

    public static void bonusTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void bonusRangeError(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorLog());
    }

    public static void bonusDuplicate(List<Integer> winNums, int bonus) {
        if (winNums.contains(bonus))
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorLog());
    }
}
