package lotto.reward;

public enum Reward {
    FIFTH(5_000L, "3개 일치 (5,000원)", 0),
    FOURTH(50_000L, "4개 일치 (50,000원)", 1),
    THIRD(1_500_000L, "5개 일치 (1,500,000원)", 2),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)", 3),
    FIRST(2_000_000_000L, "6개 일치 (2,000,000,000원)", 4);

    private final long value;
    private final String rewardName;
    private final int rewardIndex;

    Reward(long value, String rewardName, int rewardIndex) {
        this.value = value;
        this.rewardName = rewardName;
        this.rewardIndex = rewardIndex;
    }

    public long getValue() {
        return value;
    }

    public String getRewardName() {
        return rewardName;
    }

    public int getRewardIndex() {
        return rewardIndex;
    }
}
