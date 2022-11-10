package lotto;

public enum Rank {
    FIRST(1), SECOND(2), THIRD(3), FORTH(4), FIFTH(5);

    private final int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

}
