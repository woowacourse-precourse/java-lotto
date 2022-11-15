package lotto.util;

public enum Rank {
    NONE("", 0),
    FIFTH("3개 일치 (5,000원)", 5000),
    FORTH("4개 일치 (50,000원)", 50000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000);

    private final String description;
    private final int prize;

    Rank(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRankByMatchCount(int matchCount, boolean isBonusNumberMatched) {
        if (matchCount == 3) {
            return Rank.FIFTH;
        } else if (matchCount == 4) {
            return Rank.FORTH;
        } else if (matchCount == 5) {
            if (!isBonusNumberMatched) {
                return Rank.THIRD;
            }

            return Rank.SECOND;
        } else if (matchCount == 6) {
            return Rank.FIRST;
        }

        return Rank.NONE;
    }

    @Override
    public String toString() {
        return description;
    }
}
