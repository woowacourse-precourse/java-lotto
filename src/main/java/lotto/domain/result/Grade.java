package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Grade {
    FIRST("1등", 2000000000,
            ((sameNumCount, isBonusSame) -> sameNumCount == 6)),
    SECOND("2등", 30000000,
            ((sameNumCount, isBonusSame) -> sameNumCount == 5 && isBonusSame)),
    THIRD("3등", 1500000,
            ((sameNumCount, isBonusSame) -> sameNumCount == 5 && !isBonusSame)),
    FOURTH("4등", 50000,
            ((sameNumCount, isBonusSame) -> sameNumCount == 4)),
    FIFTH("5등", 5000,
            ((sameNumCount, isBonusSame) -> sameNumCount == 3)),
    NONE("없음", 0,
            ((sameNumCount, isBonusSame) -> sameNumCount < 3));

    private String name;
    private int prize;
    private BiPredicate<Integer, Boolean> condition;

    Grade(String name, int prize, BiPredicate<Integer, Boolean> condition) {
        this.name = name;
        this.prize = prize;
        this.condition = condition;
    }

    public String getName() {
        return this.name;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Grade valueOf(int sameNumCount, Boolean isBonusSame) {
        return Arrays.stream(values())
                .filter(Grade -> Grade.condition.test(sameNumCount, isBonusSame))
                .findFirst()
                .orElseThrow();
    }
}
