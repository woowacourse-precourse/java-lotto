package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    EMPTY(0, false, 0);
    private final int common;
    private final boolean bonus;
    private final int prise;

    Rank(int common, boolean bonus, int prise) {
        this.common = common;
        this.bonus = bonus;
        this.prise = prise;
    }

    public static Rank findRank(int common, boolean bonus) {
        if (common == SECOND.common() && bonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.bonus() && rank.common() == common)
                .findAny()
                .orElse(EMPTY);
    }

    public int common() {
        return common;
    }

    public boolean bonus() {
        return bonus;
    }

    public int prise() {
        return prise;
    }
}
