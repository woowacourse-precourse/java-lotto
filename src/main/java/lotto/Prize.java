package lotto;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0),

    FIFTH(3, 5000),

    FOURTH(4, 50000),

    THIRD(5, 1500000),

    SECOND(5, 30000000),

    FIRST(6, 2000000000);

    private int matchAmount;
    private int money;

    Prize(int matchAmount, int money) {
        this.matchAmount = matchAmount;
        this.money = money;
    }

    public static Prize calculatePrize(int matchAmount, boolean bonus) {
        if (matchAmount == THIRD.matchAmount && !bonus) {
            return THIRD;
        }
        if (matchAmount < FIFTH.matchAmount) {
            return MISS;
        }
        return Arrays.stream(values()).filter(rating -> rating.matchAmount == matchAmount).findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getMoney() {
        return money;
    }

}
