package lotto;

public enum LottoRank {
    NOTHING(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private static final int LOTTO_WINNING_COUNT_STANDARD = 3;

    private final int winnings;
    private final int numberOfMatch;

    LottoRank(int numberOfMatch, int winnings) {
        this.winnings = winnings;
        this.numberOfMatch = numberOfMatch;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (isNothingWinning(matchCount)) {
            return NOTHING;
        }

        if (isSecondPlace(matchCount, bonusMatch)) {
            return SECOND_PLACE;
        }

        return remainValueOf(matchCount);
    }

    private static LottoRank remainValueOf(int matchCount) {
        if (isThirdPlace(matchCount)) {
            return THIRD_PLACE;
        }

        if (isFourthPlace(matchCount)) {
            return FOURTH_PLACE;
        }

        return firstOrFifthValueOf(matchCount);
    }

    private static LottoRank firstOrFifthValueOf(int matchCount) {
        if (isFifthPlace(matchCount)) {
            return FIFTH_PLACE;
        }

        if (isFirstPlace(matchCount)) {
            return FIRST_PLACE;
        }

        throw new IllegalArgumentException();
    }

    private static boolean isNothingWinning(int matchCount) {
        return matchCount < LOTTO_WINNING_COUNT_STANDARD;
    }

    private static boolean isSecondPlace(int matchCount, boolean bonusMatch) {
        return SECOND_PLACE.numberOfMatch == matchCount && bonusMatch;
    }

    private static boolean isThirdPlace(int matchCount) {
        return THIRD_PLACE.numberOfMatch == matchCount;
    }

    private static boolean isFourthPlace(int matchCount) {
        return FOURTH_PLACE.numberOfMatch == matchCount;
    }

    private static boolean isFifthPlace(int matchCount) {
        return FIFTH_PLACE.numberOfMatch == matchCount;
    }

    private static boolean isFirstPlace(int matchCount) {
        return FIRST_PLACE.numberOfMatch == matchCount;
    }
}
