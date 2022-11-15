package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000,"5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ");

    private final int matchCount;
    private final int prize;
    private final String message;
    private int achievedCount;

    Rank(final int matchCount, final int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() { //TODO 메세지 없애고 prize로 출력하도록 수정
        return message;
    }

    public int getAchievedCount() {
        return achievedCount;
    }

    public void setAchievedCount(int achievedCount) {
        this.achievedCount = achievedCount;
    }
}
