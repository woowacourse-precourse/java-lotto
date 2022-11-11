package lotto.validator.view;

import lotto.exception.UtilClassCreateException;
import lotto.utils.StringUtils;

public class InputValidator {
    private static final String NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 입력 값은 Null 또는 Empty 일 수 없습니다.";
    
    private InputValidator() {
        throw new UtilClassCreateException();
    }
    
    
    public static void validateNullOrEmpty(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
