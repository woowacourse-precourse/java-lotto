package lotto.domain;

import java.util.Arrays;

public enum Grade {
    FIRST(new PrizeMoney(2_000_000_000), 6),
    SECOND(new PrizeMoney(30_000_000), 5),
    THIRD(new PrizeMoney(1_500_000), 5),
    FORTH(new PrizeMoney(50_000), 4),
    FIFTH(new PrizeMoney(5_000), 3),
    PASS(new PrizeMoney(0), 0);

    private final PrizeMoney prizeMoney;
    private final int count;


    Grade(PrizeMoney prizeMoney, int count) {
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public static Grade of(int hitCount, boolean bonusNumber) {
        if (hitCount == SECOND.count && bonusNumber) {
            return SECOND;
        } else if (hitCount == SECOND.count) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(grade -> grade.count != SECOND.count)
                .filter(grade -> grade.count == hitCount)
                .findFirst()
                .orElse(PASS);
    }

    public PrizeMoney getPrizeMoney() {
        return prizeMoney;
    }
}
