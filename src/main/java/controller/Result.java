package controller;

public enum Result {
    FIFTH("3개 일치","5,000", "3"),
    FOURTH("4개 일치","50,000", "4"),
    THIRD("5개 일치","1,500,000", "5"),
    SECOND("5개 일치, 보너스 볼 일치","30,000,000,000원", "Bonus"),
    FIRST("6개 일치", "2,000,000,000원", "6");
    private final String condition;
    private final String winningCount;

    private final String winningNumber;
    Result(String condition, String winningCount, String winningNumber) {
        this.condition = condition;
        this.winningCount = winningCount;
        this.winningNumber = winningNumber;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getWinningCount() {
        return this.winningCount;
    }

    public String getWinningNumber() {
        return this.winningNumber;
    }
}
