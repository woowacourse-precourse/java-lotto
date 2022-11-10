package lotto.domain.validator;

public class PaymentValidator {
    private static final String UNIT_OF_PAYMENT_EXCEPTION_MESSAGE = "[ERROR] 지불 금액은 1000의 배수여야 합니다.";
    
    private PaymentValidator() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(final int payment) {
        validateUnitOfPayment(payment);
    }
    
    private static void validateUnitOfPayment(final int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(UNIT_OF_PAYMENT_EXCEPTION_MESSAGE);
        }
    }
}
