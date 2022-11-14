package lotto.domain.lottomachine.payment;

import java.math.BigDecimal;

public class Payment {
    private final int money;

    private Payment(int money) {
        validateAmount(money);
        this.money = money;
    }

    public static Payment from(int money) {
        return new Payment(money);
    }

    public int divideBy(int price) {
        validateDivisor(price);
        return money / price;
    }

    private void validateDivisor(int number) {
        if (isZero(number)) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
    }

    private boolean isZero(int number) {
        return number == 0;
    }

    public BigDecimal createBigDecimal() {
        return BigDecimal.valueOf(money);
    }

    private void validateAmount(int money) {
        if (isLessThanPrice(money)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        if (isNotMultipleOfPrice(money)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private boolean isLessThanPrice(int number) {
        return number < 1000;
    }

    private boolean isNotMultipleOfPrice(int number) {
        return number % 1000 != 0;
    }
}
