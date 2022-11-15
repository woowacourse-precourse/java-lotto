package lotto;

public enum Rank {
    BANG(0, 0),
    FIVE(3, 5_000),
    FOUR(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private  int count;
    private int reward;

    Rank(final int count, final int reward) {
        this.count = count;
        this.reward = reward;
    }
}
