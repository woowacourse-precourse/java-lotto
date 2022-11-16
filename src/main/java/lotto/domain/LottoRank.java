package lotto.domain;

public enum LottoRank {
    FIRST_PLACE(1, 6, false, 2_000_000_000),
    SECOND_PLACE(2, 5, true, 30_000_000),
    THIRD_PLACE(3, 5, false, 1_500_000),
    FOURTH_PLACE(4, 4, false, 50_000),
    FIFTH_PLACE(5, 3, false, 5_000);

    LottoRank(int rank, int match, boolean shouldBonusMatch, int prize) {
        this.rank = rank;
        this.match = match;
        this.shouldBonusMatch = shouldBonusMatch;
        this.prize = prize;
    }

    private final int match;
    private final boolean shouldBonusMatch;
    private final int rank;
    private final int prize;

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public boolean shouldBonusMatch() {
        return shouldBonusMatch;
    }
}
