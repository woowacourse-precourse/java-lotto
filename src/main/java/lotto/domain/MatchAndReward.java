package lotto.domain;

public enum MatchAndReward {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 1),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000, 0),
    FIFTH(4, 5_000, 0);

    public final int reward;
    public final int match;
    public final int bonusMatch;

    MatchAndReward(int match, int reward, int bonusMatch) {
        this.reward = reward;
        this.match = match;
        this.bonusMatch = bonusMatch;
    }
}
