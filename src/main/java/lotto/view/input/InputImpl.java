package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {

    private static final int MIN_PAYMENT_AMOUNT = 1000;

    @Override
    public int inputPaymentAmount() {
        int paymentAmount = Integer.parseInt(Console.readLine());
        if (isAllowedPaymentAmount(paymentAmount)) {
            return paymentAmount;
        }
        return 0;
    }

    private boolean isAllowedPaymentAmount(int paymentAmount) {
        if (paymentAmount < MIN_PAYMENT_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 로또 구매 금액은 1000원입니다.");
        }
        return true;
    }
}
