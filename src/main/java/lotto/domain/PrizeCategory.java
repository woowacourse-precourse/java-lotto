package lotto.domain;

public enum PrizeCategory {
    Three("5,000원", 3),
    Four("50,000원", 4),
    Five("1,500,000원", 5),
    Sixbonus("30,000,000원", 5),
    Six("2,000,000,000원", 6);

    String winnings;
    int matchcount;

    PrizeCategory(String winnings, int matchcount) {
        this.winnings = winnings;
        this.matchcount = matchcount;
    }
}
