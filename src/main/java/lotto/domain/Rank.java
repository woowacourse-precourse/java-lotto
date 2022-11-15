package lotto.domain;

public enum Rank {
    NOTHING(0,0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int sameNumberCount;
    private final int prize;

    Rank(int sameNumberCount, int prize) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank getRank(long sameNumberCount, boolean containsBonus) {
        if (sameNumberCount == 6) {
            return FIRST;
        }
        if (sameNumberCount == 5 && containsBonus) {
            return SECOND;
        }
        if (sameNumberCount == 5) {
            return THIRD;
        }
        if (sameNumberCount == 4) {
            return FOURTH;
        }
        if (sameNumberCount == 3) {
            return FIFTH;
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        return String.format("sameNumberCount: %d, Prize: %d", getSameNumberCount(), getPrize());
    }
}
