package lotto.constant;

import java.util.Arrays;

public enum LottoMoney {

    FIRST(6, false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000),
    NO_MONEY(0, false, 0);

    private final int count;
    private final boolean bonus;
    private final int reward;

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    LottoMoney(int count, boolean bonus, int reward) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static int getRankReward(int count, boolean bonus) {
        return Arrays.stream(LottoMoney.values())
                .filter(lotto -> lotto.count == count && lotto.bonus == bonus)
                .map(lotto -> lotto.reward)
                .findAny()
                .orElse(NO_MONEY.getReward());
    }
}
