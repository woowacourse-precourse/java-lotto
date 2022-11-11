package lotto.domain.match;

public enum MatchAndReward {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(4, 5_000, false);

    private final int reward;
    private final int match;
    private final boolean requireBonus;

    MatchAndReward(int match, int reward, boolean requireBonus) {
        this.reward = reward;
        this.match = match;
        this.requireBonus = requireBonus;
    }

    public static MatchAndReward find(int match, boolean isBonusMatched) {
        if (isBonusMatched) {
            for (MatchAndReward matchAndReward : MatchAndReward.values()) {
                if (matchAndReward.requireBonus && matchAndReward.match == match) {
                    return matchAndReward;
                }
            }
        }

        for (MatchAndReward matchAndReward : MatchAndReward.values()) {
            if (!matchAndReward.requireBonus && matchAndReward.match == match) {
                return matchAndReward;
            }
        }

        return null;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }

    public boolean isRequireBonus() {
        return requireBonus;
    }
}
