package lotto.result;

public enum Rank {
    FIFTH("5,000", 3),
    FOURTH("50,000", 4),
    THIRD("1,500,000", 5),
    SECOND("30,000,000", 5),
    FIRST("2,000,000,000", 6);

    private final String winningMoney;
    private final int matchCount;

     Rank(String winningMoney, int matchCount) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
    }
}
