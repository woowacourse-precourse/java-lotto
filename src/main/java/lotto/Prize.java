package lotto;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum Prize {
    FIRST(6L, false, 2_000_000_000L),
    SECOND(5L, true, 30_000_000L),
    THIRD(5L, false, 1_500_000L),
    FOURTH(4L, false, 50_000L),
    FIFTH(3L, false, 5_000L),
    ;

    private final long numMatch;
    private final boolean needsBonusNumber;
    private final long amount;

    Prize(
            long numMatch,
            boolean needsBonusNumber,
            long amount
    ) {
        this.numMatch = numMatch;
        this.needsBonusNumber = needsBonusNumber;
        this.amount = amount;
    }

    public long getNumMatch() {
        return numMatch;
    }

    public boolean needsBonusNumber() {
        return needsBonusNumber;
    }

    public long getAmount() {
        return amount;
    }

    public static Optional<Prize> pickAnyWith(Predicate<Prize> condition) {
        return Arrays.stream(values())
                .filter(condition)
                .findAny();
    }
}
