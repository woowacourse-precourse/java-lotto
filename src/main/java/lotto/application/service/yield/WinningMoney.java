package lotto.application.service.yield;

public enum WinningMoney {

    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    private final int value;

    WinningMoney(int value) {
        this.value = value;
    }

    public int getWinningMoney() {
        return value;
    }
}
