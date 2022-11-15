package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.domain.validator.MoneyValidator;

public class PaymentCalculator {
    private final int payment;

    public PaymentCalculator(int payment) throws IllegalArgumentException {
        MoneyValidator.validatePayment(payment);
        this.payment = payment;
    }

    public double calculateEarningRatio(int totalPrize) throws IllegalArgumentException {
        MoneyValidator.validateMoneyValue(totalPrize);
        return (totalPrize * (100.0)) / payment;
    }

    public int calculateAmountByLottoPrice() {
        return payment / (LottoRule.PRICE.getValue());
    }
}
