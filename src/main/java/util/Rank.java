package util;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, false, 0, "miss");

    private int matchCount;
    private boolean isMatchBonusNumber;
    private int prize;
    private String resultMessage;

    Rank(int matchCount, boolean isMatchBonusNumber, int prize, String resultMessage) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
