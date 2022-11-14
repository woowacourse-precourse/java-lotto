package lotto.rank;

public enum Rank {
    FIFTH_PLACE(3, true, 5_000L),
    FOURTH_PLACE(4, true, 50_000L),
    THIRD_PLACE(5, true, 1_500_000L),
    SECOND_PLACE(6, true, 30_000_000L),
    FIRST_PLACE(6, false, 2_000_000_000L);


    private final int number;
    private final boolean bonusYN;
    private final long winProfit;

    Rank(int number, boolean bonusYN, long winProfit) {
        this.number = number;
        this.bonusYN = bonusYN;
        this.winProfit = winProfit;
    }

    public static Rank getRank(int number, boolean bonusYN) {
        if (number < 6) {
            bonusYN = true;
        }

        for (Rank rank : Rank.values()) {
            if (number == rank.number && bonusYN == rank.bonusYN) {
                return rank;
            }
        }
        return null;
    }

    public int getNumber() {
        return number;
    }

    public boolean getBonusYN() {
        return bonusYN;
    }

    public long getWinProfit() {
        return winProfit;
    }


}
