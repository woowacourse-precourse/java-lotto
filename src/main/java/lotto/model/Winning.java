package lotto.model;

public enum Winning {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int sameCount;
    private final int prize;
    private final String detail;

    Winning(int sameCount, int prize, String detail) {
        this.sameCount = sameCount;
        this.prize = prize;
        this.detail = detail;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDetail() {
        return detail;
    }
}
