package lotto;

public enum Winning {
    FIRST(2000000000),

    SECOND(30000000),

    THIRD(1500000),

    FOURTH(50000),

    FIFTH(5000);

    private long rank;

    Winning(long rank) {
        this.rank = rank;
    }

    public long getRankNumber() {

        return rank;
    }
}



