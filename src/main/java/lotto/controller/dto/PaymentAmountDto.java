package lotto.controller.dto;

import static java.lang.Integer.parseInt;
import static lotto.exception.ErrorMessage.*;

import lotto.exception.ErrorMessage;
import lotto.exception.MyException;

public class PaymentAmountDto {

    private static final int LOTTO_BASIC_AMOUNT = 1000;

    private final int paymentAmount;

    public PaymentAmountDto(String paymentAmount) {
        this.paymentAmount = checkPaymentAmount(paymentAmount);
    }

    private int checkPaymentAmount(String paymentAmount) {
        validInteger(paymentAmount);
        return validDivision(parseInt(paymentAmount));
    }

    private int validDivision(int paymentAmount) {
        if (paymentAmount % LOTTO_BASIC_AMOUNT != 0) {
            throw new MyException(NOT_DIVISION_PRICE);
        }
        return paymentAmount;
    }

    private void validInteger(String paymentAmount) {
        boolean isInteger = paymentAmount.chars()
                .allMatch(Character::isDigit);
        if (!isInteger) {
            throw new MyException(NOT_INTEGER_PRICE);
        }
    }

    public int getPaymentAmount() {
        return this.paymentAmount;
    }

}
