package lotto.application.service.statistic;

public enum WinningMoney {

    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final int money;

    WinningMoney(int money) {
        this.money = money;
    }

    public int getWinningMoney() {
        return money;
    }
}
