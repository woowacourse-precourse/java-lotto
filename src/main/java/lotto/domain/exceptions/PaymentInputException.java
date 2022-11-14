package lotto.domain.exceptions;

import lotto.data.ErrorMessage;
import lotto.domain.StartLotto;

public class PaymentInputException {

    public static void paymentTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void paymentChangeError() {
        if (StartLotto.payment % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.VALUE_ERROR.getErrorLog());
    }
}
