package lotto.Model;

import java.math.BigInteger;

public enum PrizeMoney {
    PRIZE_FOR_THREE_MATCHING(5000),
    PRIZE_FOR_FOUR_MATCHING(50000),
    PRIZE_FOR_FIVE_MATCHING(1500000),
    PRIZE_FOR_FIVE_MATCHING_WITH_BONUS(30000000),
    PRIZE_FOR_SIX_MATCHING(2000000000);

    private final int money;
    PrizeMoney(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
