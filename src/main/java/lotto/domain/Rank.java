package lotto.domain;

public enum Rank {
    FIRST(1, 6, false, "2,000,000,000"),
    SECOND(2, 5, true, "30,000,000"),
    THIRD(3, 5, false, "1,500,000"),
    FOURTH(4, 4, false, "50,000"),
    FIFTH(5, 3, false, "5,000");

    private final int ranking;
    private final int matchCount;
    private final boolean bonus;
    private final String reward;

    Rank(int ranking, int matchCount, boolean bonus, String reward) {
        this.ranking = ranking;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.reward = reward;
    }

    public int getRanking() {
        return this.ranking;
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
