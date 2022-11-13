package lotto.model;

public enum Winning {
    FIRST(6, 2_000_000_000, "1등"),
    SECOND(5, 30_000_000, "2등"),
    THIRD(5, 1_500_000, "3등"),
    FOURTH(4, 50_000, "4등"),
    FIFTH(3, 5_000, "5등");

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
