package exception;

import common.message.ErrorMessage;
import common.regulation.NumberRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    private static StringBuilder sb = new StringBuilder(ErrorMessage.EXCEPTION_START.getValue());

    public static void validateInputAmount(String input) {
        isAllNumeric(input);
        if (Integer.parseInt(input) % NumberRule.LOTTO_ONE_PRICE.getValue() != 0) {
            sb.append(ErrorMessage.EXCEPTION_NOT_UNIT.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void validateWinningNumbers(List<Integer> input) {
        if (!isAllWinningRange(input)) {
            sb.append(ErrorMessage.EXCEPTION_RANGE.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
        isSixWinningNumbers(input);
        isDuplicate(input);
    }

    public static void isAllNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            sb.append(ErrorMessage.EXCEPTION_ONLY_NUMERIC.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static boolean isAllWinningRange(List<Integer> input) {
        for (Integer number : input) {
            if (!(NumberRule.NUMBER_RANGE_START.getValue() <= number && number <= NumberRule.NUMBER_RANGE_END.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void isSixWinningNumbers(List<Integer> input) {
        if (input.size() != NumberRule.LOTTO_ONE_SIZE.getValue()) {
            sb.append(ErrorMessage.EXCEPTION_WINNING_SIX.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void isDuplicate(List<Integer> input) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : input) {
            set.add(num);
        }

        if (set.size() != 6) {
            sb.append(ErrorMessage.EXCEPTION_WINNING_DUPLICATE.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
