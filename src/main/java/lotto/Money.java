package lotto;

public class Money {
    private final Long amount;

    public Money(Long amount) {
        validate(amount);
        this.amount = amount;
    }

    public Long getAmountOfLotto() {
        return this.amount / 1000;
    }

    private void validate(Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 양수가 아닙니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 천원단위가 아닙니다.");
        }
    }

    private Long getAmount() {
        return amount;
    }

    public Double getRatio(Money money) {
        return (double) money.getAmount() * 100 / amount;
    }
}
