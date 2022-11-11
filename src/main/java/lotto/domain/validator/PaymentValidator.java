package lotto.domain.validator;

import lotto.exception.UtilClassCreateException;

public class PaymentValidator {
    private static final String UNIT_OF_PAYMENT_EXCEPTION_MESSAGE = "[ERROR] 지불 금액은 1000의 배수여야 합니다.";
    private static final String ZERO_PAYMENT_EXCEPTION_MESSAGE = "[ERROR] 지불금액은 0이 될 수 없습니다.";
    private static final int LOTTO_PRICE = 1000;
    
    private PaymentValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final int payment) {
        validateUnitOfPayment(payment);
        validateZeroPayment(payment);
    }
    
    private static void validateUnitOfPayment(final int payment) {
        if (isNotThousandOfUnits(payment)) {
            throw new IllegalArgumentException(UNIT_OF_PAYMENT_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNotThousandOfUnits(final int payment) {
        return payment % LOTTO_PRICE != 0;
    }
    
    private static void validateZeroPayment(final int payment) {
        if (isPaymentZero(payment)) {
            throw new IllegalArgumentException(ZERO_PAYMENT_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isPaymentZero(final int payment) {
        return payment == 0;
    }
}
