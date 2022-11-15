package lotto;

import java.util.Arrays;

public enum Numbers {
    NOTHING(0, false),
    THREE(3, false),
    FOUR(4, false),
    FIVE(5, false),
    FIVE_WITH_BONUS(5, true),
    SIX(6, false);

    private final int count;
    private final boolean bonus;

    Numbers(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
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
}
