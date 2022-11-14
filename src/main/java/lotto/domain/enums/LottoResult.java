package lotto.domain.enums;

import java.util.Arrays;

public enum LottoResult {
    NONE(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_AND_BONUS_MATCH(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int amount;

    LottoResult(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public static LottoResult of(int matchCount, boolean isMatchBonus) {
        if (matchCount == 0) {
            return NONE;
        }
        if (matchCount == 5) {
            return getLottoResultByMatchBonus(isMatchBonus);
        }
        return Arrays.stream(LottoResult.values())
                .filter(value -> value.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static LottoResult getLottoResultByMatchBonus(boolean isMatchBonus) {
        if (isMatchBonus) {
            return FIVE_AND_BONUS_MATCH;
        }
        return FIVE_MATCH;
    }
}
