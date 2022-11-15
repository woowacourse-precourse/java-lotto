package lotto;

public enum LottoReward {
    first(2_000_000_000),
    second(30_000_000),
    third(1_500_000),
    fourth(50_000),
    fifth(5_000),
    zero(0);

    private final int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}
