package lotto.view;

import lotto.view.constant.ValidationRegex;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    static final String EMPTY_VALUE_REGEX = ValidationRegex.EMPTY_VALUE.getRegex();
    static final String NUMBER_REGEX = ValidationRegex.NUMBER.getRegex();

    public static boolean isEmpty (String input) {
        return Pattern.matches(EMPTY_VALUE_REGEX, input);
    }

    public static boolean isNumber (String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

    public static boolean hasNonNumericValue (List<String> numbers) {
        for (String number : numbers) {
            if (!isNumber(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasEmptyValue (List<String> numbers) {
        for (String number : numbers) {
            if (isEmpty(number)) {
                return true;
            }
        }
        return false;
    }
}
