package lotto.domain;

public class Money {

    private final int MONEY_UNIT = 1000;
    private final int amount;

    private Money(int moneyAmount) {
        validate(moneyAmount);
        this.amount = moneyAmount;
    }

    public static Money from(int moneyAmount) {
        return new Money(moneyAmount);
    }

    private void validate(int moneyAmount) {
        if (moneyAmount < MONEY_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액의 최소단위는 1000원입니다.");
        }
        if (moneyAmount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야만 합니다.");
        }
    }

    public int getLottoCnt() {
        return amount / MONEY_UNIT;
    }

    public int get() {
        return amount;
    }


}
