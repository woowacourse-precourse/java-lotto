package constants;

public enum PrizeDivision {
    NO_DIVISION("invalid", "invalid", -1),
    FIRST("6개 일치", "2,000,000,000", 1),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", 2),
    THIRD("5개 일치", "1,500,000", 3),
    FOURTH("4개 일치", "50,000", 4),
    FIFTH("3개 일치", "5,000", 5);

    private final String matchingCount;
    private final String prizeAmount;
    private final int division;

    PrizeDivision(String matchingCount, String prizeAmount, int division) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.division = division;
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
}
