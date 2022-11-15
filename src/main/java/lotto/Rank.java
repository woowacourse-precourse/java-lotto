package lotto;

public enum Rank {
    FIFTH(5_000, 3, "3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int matchingNumber;
    private final String countingMessage;

    Rank(int prize, int matchingNumber, String countingMessage) {
        this.prize = prize;
        this.matchingNumber = matchingNumber;
        this.countingMessage = countingMessage;
    }

    public int getPrize() {
        return prize;
    }

    public String getCountingMessage() {
        return countingMessage;
    }
}
