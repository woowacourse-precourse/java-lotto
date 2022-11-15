package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ExceptionMessages;

public class PaymentLottoMoney {
    private final String PAYMENT_NUMBER_REGEX = "^[0-9]*$";
    private int paymentMoney;

    public PaymentLottoMoney(String paymentMoney) {
        isPaymentOnlyNumber(paymentMoney);
        isPaymentOneThousandUnit(toIntPaymentMoney(paymentMoney));
        this.paymentMoney = toIntPaymentMoney(paymentMoney);
    }

    private void isPaymentOnlyNumber(String paymentMoney) {
        if (!paymentMoney.matches(PAYMENT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.PAYMENT_ONLY_NUMBER);
        }
    }

    private int toIntPaymentMoney(String paymentMoney) {
        return Integer.parseInt(paymentMoney);
    }

    private void isPaymentOneThousandUnit(int paymentMoney) {
        if (paymentMoney % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessages.PAYMENT_ONLY_ONE_THOUSAND_UNIT);
        }
    }

    public int calculateNumberOfLotto() {
        return paymentMoney / Constant.LOTTO_PRICE;
    }
}
