package lotto.domain;

public class Money {
    private final int ZERO = 0;

    private int currentMoney;
    private int paidMoney;

    public Money(int money) {
        this.currentMoney = money;
        this.paidMoney = ZERO;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getInitialMoney() {
        return currentMoney + paidMoney;
    }

}
