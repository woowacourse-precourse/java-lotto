package util.exception;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import util.message.ErrorMessage;

public class Valid {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isDigit(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            return false;
        }
        return true;
    }

    public static boolean hasDuplicateNum(List<Integer> numbers) {
        HashSet hashSet = new HashSet();
        for (Integer number : numbers) {
            if (hashSet.contains(number)) {
                return true;
            }
            hashSet.add(number);
        }
        return false;
    }
}
