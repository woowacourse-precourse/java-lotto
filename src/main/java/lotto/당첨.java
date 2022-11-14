package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum 당첨 {
    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000);

    private final int matchingNumbers;
    private final int prize;

    당첨(int matchingNumbers, int prize) {
        this.matchingNumbers=matchingNumbers;
        this.prize=prize;
    }

    public static Optional<당첨> getRank(int matchingCount, boolean isBonus) {
        if(!isBonus && matchingCount==5)
            return Optional.of(THIRD);
        return Arrays.stream(당첨.values())
                .filter(당첨->당첨.matchingNumbers == matchingCount)
                .findFirst();
    }
}
