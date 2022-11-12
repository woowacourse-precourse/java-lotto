package lotto.controller.request;

import lotto.domain.money.Money;

public class LottoPurchaseRequest {

    private final Money payment;

    public LottoPurchaseRequest(final Money payment) {
        this.payment = payment;
    }

    public Money getPayment() {
        return payment;
    }
}
