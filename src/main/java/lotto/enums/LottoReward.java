package lotto.enums;

public enum LottoReward {
    CORRECT_THREE(0, 5000),
    CORRECT_FOUR(1, 50000),
    CORRECT_FIVE(2, 1500000),
    CORRECT_5_BONUS(3, 30000000),
    CORRECT_SIX(4, 2000000000);

    private final int reward;
    private final int idx;

    public int getReward() {
        return reward;
    }

    public int getIdx() {
        return idx;
    }

    LottoReward(int idx, int reward) {
        this.reward = reward;
        this.idx = idx;
    }

    public static LottoReward withIndex(int idx) {
        for (LottoReward lottoReward : LottoReward.values()) {
            if (lottoReward.idx == idx) {
                return lottoReward;
            }
        }
        throw new IllegalArgumentException();
    }

}
