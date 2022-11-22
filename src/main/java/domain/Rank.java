package domain;

public enum Rank {
    FIFTH(3, 5000,"3개 일치 (5,000원) - "),
    FOURTH(4, 50000,"4개 일치 (50,000원) - "),
    THIRD(5, 1500000,"5개 일치 (1,500,000원) - "),
    SECOND(6, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000,"6개 일치 (2,000,000,000원) - ");

    private final int winningCount;
    private final int winningMoney;
    private final String resultPrint;

    Rank(int winningCount, int winningMoney, String resultPrint) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.resultPrint = resultPrint;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getResultPrint() {
        return resultPrint;
    }
}
