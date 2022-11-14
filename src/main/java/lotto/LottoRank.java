package lotto;

public enum LottoRank {
    NOTHING(0, 0),
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, 5),
    SECOND_PLACE(30_000_000, 5),
    FIRST_PLACE(2_000_000_000, 6);

    private static final int LOTTO_WINNING_COUNT_STANDARD = 3;

    private int winnings;
    private int matchCount;

    LottoRank(int matchCount, int winnings) {
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

}
