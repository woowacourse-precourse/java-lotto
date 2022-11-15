package lotto.model;

public enum LottoRank {
    NONE(0, 0),
    RANK5(3, 5000),
    RANK4(4, 50000),
    RANK3(5, 1500000),
    RANK2(5, 30000000),
    RANK1(6, 2000000000);

    private final int matchingCount;
    private final int winningAmount;

    LottoRank(int matchingCount, int winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    public static LottoRank findRank(int matchingCount) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchingCount == matchingCount) {
                return rank;
            }
        }

        return NONE;
    }

    public int calculateTotalAmount(int count) {
        return winningAmount * count;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
