package lotto.rank;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000L),
    SECOND_PLACE(6, true, 30_000_000L),
    THIRD_PLACE(5, true, 1_500_000L),
    FOURTH_PLACE(4, true, 50_000L),
    FIFTH_PLACE(3, true, 5_000L);

    private final int number;
    private final boolean bonusYN;
    private final long winAmount;

    Rank(int number, boolean bonusYN, long winAmount) {
        this.number = number;
        this.bonusYN = bonusYN;
        this.winAmount = winAmount;
    }

    public static Rank getRank(int number, boolean bonusYN) {
        if (number < 5) {
            bonusYN = true;
        }

        for (Rank rank : Rank.values()) {
            if (number == rank.number && bonusYN == rank.bonusYN) {
                return rank;
            }
        }
        return null;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public long getTotalAmount(int count) {
        return winAmount * count;
    }

}
