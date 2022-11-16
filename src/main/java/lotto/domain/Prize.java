package lotto.domain;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Prize {
    NOTHING(0, Money.from(0L), (matchCount, isBonus) -> matchCount < 3),
    FIFTH(3, Money.from(5_000L), (matchCount, isBonus) -> matchCount == 3),
    FOURTH(4, Money.from(50_000L), (matchCount, isBonus) -> matchCount == 4),
    THIRD(5, Money.from(1_500_000L), (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    SECOND(5, Money.from(3_000_000L), (matchCount, isBonus) -> matchCount == 5 && isBonus),
    FIRST(6, Money.from(2_000_000_000L), (matchCount, isBonus) -> matchCount == 6);

    private final int matchCount;
    private final Money winnings;

    private final BiFunction<Integer, Boolean, Boolean> winningRule;

    Prize(int matchCount, Money winnings, BiFunction<Integer, Boolean, Boolean> winningRule) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.winningRule = winningRule;
    }

    public static Prize getPrize(int matchedCount, boolean bonusNumberMatched) {
        return Stream.of(values())
                .filter(winningType -> winningType.winningRule.apply(matchedCount, bonusNumberMatched))
                .findFirst()
                .orElse(NOTHING);
    }

    public long getCondition() {
        return matchCount;
    }

    public Money getWinnings() {
        return winnings;
    }
}
