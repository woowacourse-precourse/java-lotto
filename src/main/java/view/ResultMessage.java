package view;

public enum ResultMessage {
    FIFTH("3개 일치", "5,000", "3"),
    FOURTH("4개 일치", "50,000", "4"),
    THIRD("5개 일치", "1,500,000", "5"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000", "Bonus"),
    FIRST("6개 일치", "2,000,000,000", "6");
    private final String condition;
    private final String winningYield;

    private final String includeCount;

    ResultMessage(String condition, String winningYield, String includeCount) {
        this.condition = condition;
        this.winningYield = winningYield;
        this.includeCount = includeCount;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getWinningYield() {
        return this.winningYield;
    }

    public String getWinningNumber() {
        return this.includeCount;
    }
}
