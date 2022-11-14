package constants;

public enum PrizeDivision {
    NO_DIVISION("invalid", -1, -1, -1),
    FIRST("6개 일치", 2_000_000_000, 6, 0),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000, 5, 1),
    THIRD("5개 일치", 1_500_000, 5, 0),
    FOURTH("4개 일치", 50_000, 4, 0),
    FIFTH("3개 일치", 5_000, 3, 0);

    private final String matchingCountText;
    private final int prizeAmount;
    private final int matchingCount;
    private final int bonusCount;

    PrizeDivision(String matchingCountText, int prizeAmount, int matchingCount, int bonusCount) {
        this.matchingCountText = matchingCountText;
        this.prizeAmount = prizeAmount;
        this.matchingCount = matchingCount;
        this.bonusCount = bonusCount;
    }

    public String getMatchingCountText() {
        return matchingCountText;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}
