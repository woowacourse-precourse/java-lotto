package lotto.resources;

public enum Rank {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000),
    NOTHING(0);

    private int prizeMoney;

    Rank(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
