package lotto.domain;

public enum WinningStandard {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5, 1500000),
    FOURTH(4,50000),
    FIFTH(3, 5000);

    private int number;
    private int won;

    public int getNumber() {
        return number;
    }

    public int getWon() {
        return won;
    }

    WinningStandard(int number, int won) {
        this.number = number;
        this.won = won;
    }
}
