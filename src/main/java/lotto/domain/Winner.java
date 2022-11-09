package lotto.domain;

public enum Winner {
    FIRST(1, false, 2000000000),
    SECOND(2, true, 30000000),
    THIRD(3, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(5, false, 5000),
    NONE(0, false, 0);

    private int rank;
    private boolean value;
    private int prizeMoney;

    Winner(int rank, boolean value, int prizeMoney) {
        this.rank = rank;
        this.value = value;
        this.prizeMoney = prizeMoney;
    }

}
