package lotto.domain;

public enum CorrectNum {
    THREE(0, 5000),
    FOUR(0, 50000),
    FIVE(0, 1500000),
    FIVE_BONUS(0, 30000000),
    SIX(0, 2000000000),
    NOTHING(0, 0);

    private int cnt;
    private int prizeMoney;

    CorrectNum(int cnt, int prizeMoney) {
        this.cnt = cnt;
        this.prizeMoney = prizeMoney;
    }

    public int Cnt() {
        return cnt;
    }

    public int PrizeMoney() {
        return prizeMoney;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}

