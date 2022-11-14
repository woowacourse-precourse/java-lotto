package exception;

import common.message.ErrorMessage;
import common.regulation.NumberRule;

public class InputException {

    private static StringBuilder sb = new StringBuilder(ErrorMessage.EXCEPTION_START.getValue());

    public static void validateInputAmount(String input) {
        if(!input.chars().allMatch(Character::isDigit)) {
            sb.append(ErrorMessage.EXCEPTION_ONLY_NUMERIC.getValue());
            throw new IllegalArgumentException(sb.toString());
        }

        if(Integer.parseInt(input) % NumberRule.LOTTO_ONE_PRICE.getValue() != 0) {
            sb.append(ErrorMessage.EXCEPTION_NOT_UNIT.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
