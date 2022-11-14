package lotto.domain;

import static lotto.domain.Constants.Money.MAXIMUM_AMOUNT;
import static lotto.domain.Constants.Money.MINIMUM_AMOUNT;
import static lotto.domain.Constants.Money.UNIT_AMOUNT;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateMinimumAmount(amount);
        validateMaximumAmount(amount);
        validateUnitAmount(amount);
        this.amount = amount;
    }

    public int calculateQuantity() {
        return amount / UNIT_AMOUNT;
    }

    public double calculateYield(long totalPrize) {
        return 100D * totalPrize / amount;
    }

    private static void validateMinimumAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 구매해야 합니다.");
        }
    }

    private static void validateMaximumAmount(int money) {
        if (money > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 한도는 최대 10만원까지입니다.");
        }
    }

    private static void validateUnitAmount(int money) {
        if (money % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}