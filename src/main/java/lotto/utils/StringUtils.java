package lotto.utils;

import lotto.domain.validator.ValidatorExceptionMessageConstants;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static boolean isBlank(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
