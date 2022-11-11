package constants;

public enum PrizeDivision {
    NO_DIVISION("invalid", "invalid", -1,-1,-1),
    FIRST("6개 일치", "2,000,000,000", 1, 6, 0),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", 2, 5, 1),
    THIRD("5개 일치", "1,500,000", 3, 5, 0),
    FOURTH("4개 일치", "50,000", 4, 4, 0),
    FIFTH("3개 일치", "5,000", 5, 3, 0);

    private final String matchingCount;
    private final String prizeAmount;
    private final int division;
    private final int sameNumberCount;
    private final int bonusCount;

    PrizeDivision(String matchingCount, String prizeAmount, int division, int sameNumberCount, int bonusCount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.division = division;
        this.sameNumberCount = sameNumberCount;
        this.bonusCount = bonusCount;
    }

    public String getMatchingCount() {
        return matchingCount;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public int getDivision() {
        return division;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}
