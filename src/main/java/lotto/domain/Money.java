package lotto.domain;

public class Money {
    private static final int PRICE = 1000;

    private final long money;

    public Money(long money) {
        if (money % PRICE != 0 || money < PRICE) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 금액을 입력해주세요.");
        }
        this.money = money;
    }

    public double yield(long reward) {
        double yield = 100 * reward / (double) money;
        return Math.round(yield * 10) / 10.0;
    }

    public long count() {
        return money / PRICE;
    }
}
