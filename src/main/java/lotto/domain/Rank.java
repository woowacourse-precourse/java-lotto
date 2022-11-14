package lotto.domain;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int hitCount;
    private final int reward;
    private final boolean hasBonusNumber;

    Rank(int hitCount, int reward, boolean hasBonusNumber) {
        this.hitCount = hitCount;
        this.reward = reward;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank calculateRank(int hitCount, boolean hasBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (hitCount != 5 && rank.hitCount == hitCount) {
                return rank;
            }
            if (rank.hitCount == 5 && rank.hitCount == hitCount) {
                if (hasBonusNumber) {
                    return SECOND;
                }
                return THIRD;
            }
        }
        return null;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getReward() {
        return reward;
    }
}
