package lotto.domain;

public enum Rank {
    FIRST("6개 일치", "2,000,000,000"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000"),
    THIRD("5개 일치", "1,500,000"),
    FORTH("4개 일치", "50,000"),
    FIFTH("3개 일치", "5,000"),
    NOTHING("3개 미만 일치", "0");

    private String matchCount;
    private String winnings;

    Rank(String matchCount, String winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }
}
