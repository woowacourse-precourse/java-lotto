package lotto;

public enum Prizecut {

    FIFTH(5000, "(5,000원)"),
    FOURTH(50000, "(50,000원)"),
    THIRD(1500000, "(1,500,000원)"),
    FIRST(2000000000, "(2,000,000,000원)"),
    SECOND(30000000, "(30,000,000원)");

    private final int prizeMoney;
    private final String prizePhrase;

    Prizecut(int prizeMoney, String prizePhrase) {
        this.prizeMoney = prizeMoney;
        this.prizePhrase = prizePhrase;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizePhrase() {
        return prizePhrase;
    }
}
