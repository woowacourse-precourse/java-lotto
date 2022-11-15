package lotto.domain;

public enum Rank {

    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000"),
    SECOND(5, 30_000_000L, "30,000,000");

    private final int match;
    private final long reward;
    private final String strReward;

    Rank(int match, long reward, String strReward) {
        this.match = match;
        this.reward = reward;
        this.strReward = strReward;
    }

    public long calculatePrize(int count) {
        return this.reward * count;
    }

    public int getMatch() {
        return this.match;
    }

    public long getReward() {
        return this.reward;
    }

    public String getStrReward() {
        return this.strReward;
    }
}
