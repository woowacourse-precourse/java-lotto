package lotto.domain;

public enum PrizeCategory {
    THREE("5,000원", 5000, 3),
    FOUR("50,000원", 50000, 4),
    FIVE("1,500,000원", 1500000, 5),
    SIXBONUS("30,000,000원", 30000000, 5),
    SIX("2,000,000,000원", 2000000000, 6);

    String winningsPrint;
    int winnings;
    int matchCount;

    PrizeCategory(String winningsPrint, int winnings, int matchCount) {
        this.winningsPrint = winningsPrint;
        this.winnings = winnings;
        this.matchCount = matchCount;
    }
}
