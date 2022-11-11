package lotto.view.validator;

import lotto.domain.validator.ValidatorExceptionMessageConstants;
import lotto.utils.StringUtils;

public class InputValidator {
    private static final String NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 입력 값은 Null 또는 Empty 일 수 없습니다.";
    
    private InputValidator() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    
    public static void validateNullOrEmpty(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
