package lotto;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5.5f, 30_000_000),
    ALL_MATCH(6, 2_000_000_000);

    private float matching;
    private long prize;

    Rank(float matching, long prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public float getMatching() {
        return this.matching;
    }

    public long getPrize() {
        return this.prize;
    }
}
