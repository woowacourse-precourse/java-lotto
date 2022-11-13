package lotto;

public enum Result {
    FIFTH(3, 5000, "5,000"),
    FOURTH(4, 50000, "50,000"),
    THIRD(5, 1500000, "1,500,000"),
    SECOND(-1, 30000000, "30,000,000"),
    FIRST(6, 2000000000, "2,000,000,000");

    private final int correctCount, prize;
    private final String prizeString;

    Result(int correctCount, int prize, String prizeString) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.prizeString = prizeString;
    }

    public int correctCount() {
        return correctCount;
    }

    public int prize() {
        return prize;
    }

    public String prizeString() {
        return prizeString;
    }
}
