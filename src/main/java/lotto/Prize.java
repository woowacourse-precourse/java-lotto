package lotto;


import static lotto.Company.*;

public enum Prize {
    ONE(2000000000),
    TWO(30000000),
    THREE(1500000),
    FOUR(50000),
    FIVE(5000),
    BANG(0);

    private final Integer prizeMoney;

    Prize(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
    public static Prize getPrize(Integer count) {
        if (count.equals(PRIZE_ONE)) {
            return ONE;
        }
        if (count.equals(PRIZE_THREE)) {
            return THREE;
        }
        if (count.equals(PRIZE_FOUR)) {
            return FOUR;
        }
        if (count.equals(PRIZE_FIVE)) {
            return FIVE;
        }
        return BANG;
    }
}
