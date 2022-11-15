package lotto.domain;

import lotto.validator.InputValidator;

public class Payment {
    private final int payment;

    public Payment(int payment) {
        validate(payment);
        this.payment = payment;
    }

    public int getAvailableLottoAmount() {
        return payment / LottoCondition.PRICE.getNumber();
    }

    private void validate(int payment) {
        InputValidator.validateZero(payment);
        InputValidator.validatePayment(payment, LottoCondition.PRICE.getNumber());
    }
}
