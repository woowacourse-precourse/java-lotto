package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST_PLACE(2000000000, 6),
    SECOND_PLACE(30000000, 5),
    THIRD_PLACE(1500000, 5),
    FOURTH_PLACE(50000, 4),
    FIFTH_PLACE(5000, 3),
    LAST_PLACE(0, 0);

    private final int amount;
    private final int matchingCount;

    LottoResult(int amount, int matchingCount) {
        this.amount = amount;
        this.matchingCount = matchingCount;
    }

    public static LottoResult of(int matchingCount, boolean containsBonusNumber) {
        if (isLastPlace(matchingCount)) {
            return LAST_PLACE;
        }
        if (isSecondOrThirdPlace(matchingCount)) {
            if (containsBonusNumber) {
                return SECOND_PLACE;
            }
            return THIRD_PLACE;
        }
        return getResultByMatchingCount(matchingCount);
    }

    private static boolean isLastPlace(int matchingCount) {
        return matchingCount < FIFTH_PLACE.getMatchingCount();
    }

    private static boolean isSecondOrThirdPlace(int matchingCount) {
        return matchingCount == SECOND_PLACE.getMatchingCount();
    }

    private static LottoResult getResultByMatchingCount(int matchingCount) {
        LottoResult[] results = values();
        return Arrays.stream(results)
                .filter(result -> result.hasSameMatchingCount(matchingCount))
                .findFirst()
                .get();
    }

    private boolean hasSameMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean win() {
        return matchingCount >= FIFTH_PLACE.getMatchingCount();
    }
}
