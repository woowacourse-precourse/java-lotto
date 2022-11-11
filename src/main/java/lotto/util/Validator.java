package lotto.util;

import java.util.List;

public abstract class Validator {
    public static <T> boolean isNotNull(T object) {
        return object != null;
    }

    public static boolean isNotEmpty(String string) {
        return !string.equals("");
    }

    public static <T> boolean isListInSize(List<T> list, int size) {
        return list.size() == size;
    }

    public static boolean isIntegerInRange(int integer, int startInclusive, int endInclusive) {
        return integer >= startInclusive
                && integer <= endInclusive;
    }

    public static <T> boolean isInteger(T input) {
        try {
            Integer.parseInt((String) input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
