package lotto.resources;

public enum Rank {
    FIRST_PLACE(2000000000, 1),
    SECOND_PLACE(30000000, 2),
    THIRD_PLACE(1500000, 3),
    FOURTH_PLACE(50000, 4),
    FIFTH_PLACE(5000, 5),
    NOTHING(0, 0);

    private int prizeMoney;
    private int rank;

    Rank(int prizeMoney, int rank) {
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getRank() {
        return rank;
    }
}
