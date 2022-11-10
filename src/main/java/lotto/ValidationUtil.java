package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    public static void isValidNumber(String str) {
        int number = Integer.parseInt(str);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getValue());
        }
    }

    public static void isValidCount(String[] array) {
        if (array.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getValue());
        }
    }

    private static void hasDistinctNumbers(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        if (set.size() != array.length) {
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
        }
    }

    public static boolean isValid(String str) {
        String[] split = str.split(",");
        isValidCount(split);
        for (String s : split) {
            isValidNumber(s);
        }
        hasDistinctNumbers(split);
        return true;
    }
}
