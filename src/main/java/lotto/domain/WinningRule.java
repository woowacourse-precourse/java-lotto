package lotto.domain;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum WinningRule {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOT_WINNER(-1, false, 0);

    private final int matchesCount;
    private final boolean isRequiredBonusNumber;
    private final int winningAmount;

    WinningRule(int matchesCount, boolean isRequiredBonusNumber, int winningAmount) {
        this.matchesCount = matchesCount;
        this.isRequiredBonusNumber = isRequiredBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static Optional<WinningRule> check(Map<String, Object> result) {
        return Stream.of(values())
                .filter(enumType -> enumType.matchesCount == (int) result.get("count"))
                .filter(enumType -> enumType.isRequiredBonusNumber == (boolean) result.get("bonus"))
                .findAny();
    }

    public int winningAmount() {
        return winningAmount;
    }
}
