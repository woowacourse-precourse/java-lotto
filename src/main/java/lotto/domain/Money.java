package lotto.domain;

public class Money {

    private final Long amount;

    private Money(Long money) {
        this.amount = money;

    }

    public static Money of(Long money) {
        return new Money(money);
    }
    public  Double calcYield(Long prizeMoney) {
        return (double) (this.amount / prizeMoney * 100);
    }

    public int calcLottoQuantity() {
        return amount.intValue() / 1000;
    }

}