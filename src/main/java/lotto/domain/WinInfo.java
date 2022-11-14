package lotto.domain;

public enum WinInfo {
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5, "30,000,000"),
    FIRST(6, "2,000,000,000");

    private final int match;
    private final String winnings;

    WinInfo(int match, String winnings) {
        this.match = match;
        this.winnings = winnings;
    }

    public int getMatch() {
        return this.match;
    }

    public String getWinnings() {
        return this.winnings;
    }
}
