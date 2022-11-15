package lotto.domain;

public enum LottoReward {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);

    private final int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public static LottoReward findByName(String name) {
        LottoReward[] lottoRewards = LottoReward.values();
        LottoReward lottoReward = null;
        for (LottoReward reward : lottoRewards) {
            if (reward.name().equals(name)) {
                lottoReward = reward;
            }
        }
        return lottoReward;
    }

    public int getReward() {
        return this.reward;
    }
}
