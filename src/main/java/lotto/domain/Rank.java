package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private final int matchedNumberCount;
    private final int winningMoney;
    private final String message;

    Rank(int matchedNumberCount, int winningMoney, String message) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank valueOf(int matchedNumberCount, boolean isBonusNumberMatched) {
        if (SECOND.isValidCount(matchedNumberCount) && isBonusNumberMatched) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.isValidCount(matchedNumberCount) && rank != SECOND) {
                return rank;
            }
        }

        return MISS;
    }

    private boolean isValidCount(int matchedNumberCount) {
        return this.matchedNumberCount == matchedNumberCount;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            System.out.println(message + count + "개");
        }
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
