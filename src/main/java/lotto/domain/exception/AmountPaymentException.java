package lotto.domain.exception;

import lotto.constants.ExceptionMessage;

public class AmountPaymentException {
    private static final int PRICE = 1000;
    private static final String REGULAR_PATTERN = "^[0-9]*$";

    public void inputVerification(int lottoPayment) {
        validateSizeLottos(lottoPayment);
        validateZero(lottoPayment);
    }

    public void validateCharacters(String readLine) {
        if (!(readLine.matches(REGULAR_PATTERN))) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_CHARACTERS);
        }
    }

    public void validateSizeLottos(int lottoPayment) {
        if (lottoPayment % PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.THOUSAND_WON_UNIT_EXCEPTION);
        }
    }

    public void validateZero(int lottoPayment) {
        if (lottoPayment <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.PAYMENT_AMOUNT_ZERO);
        }
    }
}
