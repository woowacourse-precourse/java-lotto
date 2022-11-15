package lotto.domain;

import java.util.Arrays;

public enum Prize {
    NOTHING(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_AND_BOUNS(5, true, 30000000),
    ALL(6, false, 2000000000);

    private final int count;
    private final boolean bonus;
    private final int money;

    Prize(int count, boolean bonus, int money) {
        this.count = count;
        this.bonus = bonus;
        this.money = money;
    }

    public static Prize valueOf(int count, boolean bonus) {
        if (countFiveAndBonus(count, bonus)) {
            return FIVE_AND_BOUNS;
        }
        return Arrays.stream(values())
            .filter(result -> result.count == count)
            .findFirst()
            .orElse(NOTHING);
    }

    private static boolean countFiveAndBonus(int count, boolean bonus) {
        return count == FIVE_AND_BOUNS.count && bonus;
    }

    public int getMoney() {
        return money;
    }
}
