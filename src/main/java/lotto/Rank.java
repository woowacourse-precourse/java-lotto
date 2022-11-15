package lotto;

public enum Rank {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    NONE(0, "0");

    private final int match;
    private final String prize;

    Rank(int match, String prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return this.match;
    }

    public String getPrize() {
        return this.prize;
    }
}
