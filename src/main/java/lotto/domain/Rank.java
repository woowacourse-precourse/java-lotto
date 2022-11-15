package lotto.domain;

import java.util.Optional;

public enum Rank {
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    ;

    private final Integer matchedNumbers;
    private final Integer winningAmount;

    Rank(Integer matchedNumbers, Integer winningAmount) {
        this.matchedNumbers = matchedNumbers;
        this.winningAmount = winningAmount;
    }

    public static Optional<Rank> of(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6) {
            return Optional.of(FIRST);
        }
        if (matchedNumbers == 5) {
            return getSameMatchedNumberRank(hasBonusNumber);
        }
        if (matchedNumbers == 4) {
            return Optional.of(FORTH);
        }
        if (matchedNumbers == 3) {
            return Optional.of(FIFTH);
        }
        return Optional.empty();
    }

    private static Optional<Rank> getSameMatchedNumberRank(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return Optional.of(SECOND);
        }
        return Optional.of(THIRD);
    }

    public Integer getMatchedNumbers() {
        return matchedNumbers;
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }
}
