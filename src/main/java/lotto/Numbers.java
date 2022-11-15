package lotto;

import java.util.Arrays;

public enum Numbers {
    NOTHING(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_WITH_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int count;
    private final boolean bonus;
    private final int amount;

    Numbers(int count, boolean bonus, int amount) {
        this.count = count;
        this.bonus = bonus;
        this.amount = amount;
    }

    public static Numbers findRank(int count, boolean bonus) {
        if (checkBonus(count, bonus)) {
            return FIVE_WITH_BONUS;
        }
        return Arrays.stream(values())
                .filter(rank ->  rank.match(count))
                .findFirst()
                .orElse(NOTHING);
    }

    public boolean match(int count) {
        return this.count == count;
    }

    public static boolean checkBonus(int count, boolean bonus) {
        return count == 5 && bonus;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }
}
