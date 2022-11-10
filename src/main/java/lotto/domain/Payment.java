package lotto.domain;

import lotto.domain.validator.PaymentValidator;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    
    private final int payment;
    
    public Payment(final int payment) {
        validate(payment);
        this.payment = payment;
    }
    
    private void validate(final int payment) {
        PaymentValidator.validate(payment);
    }
    
    public int countOfPurchasedLotto() {
        return payment / LOTTO_PRICE;
    }
}
