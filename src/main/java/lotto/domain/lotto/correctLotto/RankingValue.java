package lotto.domain.lotto.correctLotto;

import java.util.Arrays;

public enum RankingValue {
    OUT(0, false),
    FIRST(6, false),
    SECOND(6, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    ;

    private final Integer count;
    private final boolean bonus;

    RankingValue(Integer count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    public Integer getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static boolean findRankingValue(RankingValue value, int count, boolean bonus) {
        return (value.getCount() == count) && (value.isBonus() == bonus);
    }
}
