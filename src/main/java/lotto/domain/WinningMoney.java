package lotto.domain;

public enum WinningMoney {
    FIVE_THOUSAND(5000),
    FIFTY_THOUSAND(50000),
    ONE_MILLION_AND_A_HALF_MILLION(1500000),
    THIRTY_MILLION(30000000),
    TWO_BILLION(2000000000);

    private int winningMoney;

    WinningMoney(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
