package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoResult {
    NONE(0, 0, (matchCount, isMatchBonus) -> matchCount < 3),
    THREE_MATCH(3, 5_000, (matchCount, isMatchBonus) -> matchCount == 3),
    FOUR_MATCH(4, 50_000, (matchCount, isMatchBonus) -> matchCount == 4),
    FIVE_MATCH(5, 1_500_000, (matchCount, isMatchBonus) -> matchCount == 5 && !isMatchBonus),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, (matchCount, isMatchBonus) -> matchCount == 5 && isMatchBonus),
    SIX_MATCH(6, 2_000_000_000, (matchCount, isMatchBonus) -> matchCount == 6);

    private final int matchCount;
    private final int amount;
    private final BiPredicate<Integer, Boolean> matcher;

    LottoResult(int matchCount, int amount, BiPredicate<Integer, Boolean> matcher) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.matcher = matcher;
    }

    public static LottoResult of(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(value -> value.matcher.test(matchCount, isMatchBonus))
                .findFirst()
                .orElse(NONE);
    }

    public boolean hasBonusNumber() {
        return this == FIVE_AND_BONUS_MATCH;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}
