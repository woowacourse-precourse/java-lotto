package lotto.config;

public enum LottoReward {

    FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000), FORTH(50_000), FIFTH(5_000);

    private int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return String.format("%,d원", reward);
    }
}
