package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 올바르지 않은 입력입니다.";
    public static final String INVALID_COST_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해야합니다.";

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
