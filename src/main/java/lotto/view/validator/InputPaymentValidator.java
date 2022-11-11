package lotto.view.validator;

import lotto.domain.validator.ValidatorExceptionMessageConstants;

public class InputPaymentValidator {
    private InputPaymentValidator() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(final String inputPayment) {
        validateNullOrEmpty(inputPayment);
    }
    
    private static void validateNullOrEmpty(final String inputPayment) {
        InputValidator.validateNullOrEmpty(inputPayment);
    }
}
