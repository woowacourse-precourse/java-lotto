package lotto.domain;

public enum LottoReward {

    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    EMPTY(0, 0);

    public final int REWARD;
    public final int COUNT;

    LottoReward(int REWARD, int COUNT) {
        this.REWARD = REWARD;
        this.COUNT = COUNT;
    }

    public static LottoReward getAward(int count, boolean hasBonusNumber) {
        if (count == 6) return FIRST;
        if (count == 5 && hasBonusNumber) return SECOND;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return EMPTY;
    }

    @Override
    public String toString() {
        return String.format("%,d원", REWARD);
    }

}
