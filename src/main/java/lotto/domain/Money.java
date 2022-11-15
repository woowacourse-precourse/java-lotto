package lotto.domain;

import lotto.util.errorMessage.ErrorMessage;

public class Money {

    private static final int MIN_UNIT = 1000;
    private static final int RATE_UNIT = 100;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        validateMinimumMoney(money);
        this.money = money;
    }

    private void validateMinimumMoney(int money){
        if (money<MIN_UNIT){
            throw new IllegalArgumentException(ErrorMessage.MININUM_PAYMENT);
        }
    }

    private void validateMoney(int money) {
        if (cannotPay(money)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_UNIT_ERROR);
        }
    }

    private static boolean cannotPay(int money) {
        return money % MIN_UNIT != 0;
    }

    public static int calculateQuotient(Money money) {
        return money.money / MIN_UNIT;
    }

    public static float calculateProfitRate(float profit, Money money){
        return profit / money.money * RATE_UNIT;
    }
}
