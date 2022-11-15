package lotto.domain;

public enum LottoReward {
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, 6),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 5),
    THIRD("5개 일치 (1,500,000원) - ", 1500000, 5),
    FOURTH("4개 일치 (50,000원) - ", 50000, 4),
    FIFTH("3개 일치 (5,000원) - ", 5000, 3);

    private final String rewardMessage;
    private final long reward;
    private final int matchCount;

    LottoReward(String rewardMessage, int reward, int matchCount) {
        this.rewardMessage = rewardMessage;
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public String getRewardMessage() {
        return rewardMessage;
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
