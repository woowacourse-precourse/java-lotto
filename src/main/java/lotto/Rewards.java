package lotto;

public enum Rewards {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    NO_PLACE(0, false, 0);

    public final int matchingNumberCount;
    public final boolean isBonusNumberMatches;
    public final int reward;

    Rewards(int matchingNumberCount, boolean isBonusNumberMatches, int reward) {
        this.matchingNumberCount = matchingNumberCount;
        this.reward = reward;
        this.isBonusNumberMatches = isBonusNumberMatches;
    }

    public static Rewards getReward(int matchingNumber, boolean isBonusNumberMatches) {
        for (int idx = 0; idx< Rewards.values().length; idx++) {
            Rewards[] rewards = Rewards.values();
            if (matchingNumber == rewards[idx].matchingNumberCount && isBonusNumberMatches == rewards[idx].isBonusNumberMatches) {
                return rewards[idx];
            }
        }
        return NO_PLACE;
    }
}
