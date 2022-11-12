package lotto.application.service.yield;

public enum WinningMoney {

    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    private final int money;

    WinningMoney(int money) {
        this.money = money;
    }

    public int getWinningMoney() {
        return money;
    }
}
