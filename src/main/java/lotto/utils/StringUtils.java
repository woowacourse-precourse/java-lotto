package lotto.utils;

import lotto.exception.UtilClassCreateException;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {
        throw new UtilClassCreateException();
    }
    
    public static boolean isBlank(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
