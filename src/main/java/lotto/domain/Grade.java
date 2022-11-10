package lotto.domain;

import java.util.Arrays;

public enum Grade {
    FIRST(new Money(2_000_000_000), 6),
    SECOND(new Money(30_000_000), 5),
    THIRD(new Money(1_500_000), 5),
    FORTH(new Money(50_000), 4),
    FIFTH(new Money(5_000), 3),
    PASS(new Money(0),0);

    private final Money winningMoney;
    private final int count;


    Grade(Money winningMoney, int count) {
        this.winningMoney = winningMoney;
        this.count = count;
    }

    public static Grade of(int hitCount, boolean hasBonusNumber) {
        if (hitCount == SECOND.count && hasBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values()).filter(grade -> grade.count != SECOND.count)
                .filter(grade -> grade.count == hitCount)
                .findFirst()
                .orElse(PASS);
    }
}
