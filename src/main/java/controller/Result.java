package controller;

public enum Result {
    FIRST("6개 일치", "2,000,000,000원"),
    SECOND("5개 일치, 보너스 볼 일치","30,000,000,000원"),
    THIRD("5개 일치","1,500,000"),
    FOURTH("4개 일치","50,000"),
    FIFTH("3개 일치","5,000");

    private final String condition;
    private final String winningCount;
    Result(String condition, String winningCount) {
        this.condition = condition;
        this.winningCount = winningCount;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getWinningCount() {
        return this.winningCount;
    }
}
