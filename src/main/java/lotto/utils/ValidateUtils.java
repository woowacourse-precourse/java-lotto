package lotto.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static boolean isNumber(String value){
        return Pattern.matches(Constants.NUMBER_REGEX, value);
    }
}
