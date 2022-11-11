package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    OTHER(0, 0);

    private final int count;
    private final int prize;

    Rank(Integer count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank valueOf(int count, boolean bonus) {
        if (count < 3) {
            return OTHER;
        }

        if (SECOND.matchCount(count) && bonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(count) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException();
    }

    private boolean matchCount(int count) {
        return this.count == count;
    }
}
