package lotto.domain;

public enum Match {
    THREE(3, false, "5,000"),
    FOUR(4, false, "50,000"),
    FIVE(5, false, "1,500,000"),
    FIVE_BONUS(5, true, "30,000,000"),
    SIX(6, false, "2,000,000,000");

    private final int matchCount;
    private final boolean bonus;
    private final String reward;

    Match(int matchCount, boolean bonus, String reward) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.reward = reward;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getBonus() {
        return this.bonus;
    }

    public String getReward() {
        return this.reward;
    }
}
