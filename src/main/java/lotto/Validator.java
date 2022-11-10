package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.Constants.*;

public class Validator {

    public static void validateForIllegalInput(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateForDividedBy1000(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_COST_ERROR_MESSAGE);
        }
    }
}
