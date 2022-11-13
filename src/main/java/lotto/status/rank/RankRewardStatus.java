package lotto.status.rank;

public enum RankRewardStatus {
    rank1(2000000000),
    rank2(30000000),
    rank3(1500000),
    rank4(50000),
    rank5(5000);

    private long reward;

    RankRewardStatus(int reward) {
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }
}
