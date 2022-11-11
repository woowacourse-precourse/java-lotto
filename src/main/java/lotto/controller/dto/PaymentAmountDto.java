package lotto.controller.dto;

import static java.lang.Integer.parseInt;

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
            throw new IllegalArgumentException("[ERROR] 지불금액이 1000으로 나누어 떨어지지 않습니다.");
        }
        return paymentAmount;
    }

    private void validInteger(String paymentAmount) {
        boolean isInteger = paymentAmount.chars()
                .allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 지불금액에 정수값이 아닌 값이 포함되어 있습니다.");
        }
    }

}
