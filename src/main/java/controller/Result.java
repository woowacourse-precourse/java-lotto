package controller;

public enum Result {
    FIRST("6개 번호 일치", "2,000,000,000원", 6),
    SECOND("5개 번호 + 보너스 번호 일치","30,000,000,000원",5),
    THIRD("5개 번호 일치","1,500,000", 5),
    FOURTH("4개 번호 일치","50,000",4),
    FIFTH("3개 번호 일치","5,000",3);

    private final String condition;
    private final String winningCount;
    private final int winningNumber;
    Result(String condition, String winningCount, int winningNumber) {
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

    public int getWinningNumber() {
        return this.winningNumber;
    }
}
