package lotto.Domain;

public enum WinningPrice {
    FIRST(2000000000, 6, 0, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, 5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, 5, 0, "5개 일치 (1,500,000원) - "),
    FORTH(50000, 4, 0, "4개 일치 (50,000원) - "),
    FIFTH(5000, 3, 0, "3개 일치 (5,000원) - ");

    private int prizeMoney;
    private int theNumberOfWins;
    private int winningBonus;
    private String winningMessage;

    WinningPrice(int prizeMoney, int theNumberOfWins, int winningBonus, String winningMessage) {
        this.prizeMoney = prizeMoney;
        this.theNumberOfWins = theNumberOfWins;
        this.winningBonus = winningBonus;
        this.winningMessage = winningMessage;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getTheNumberOfWins() {
        return theNumberOfWins;
    }

    public int getWinningBonus() {
        return winningBonus;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
