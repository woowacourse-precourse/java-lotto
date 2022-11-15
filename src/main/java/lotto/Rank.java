package lotto;

public enum Rank {
    FIFTH_PLACE(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH_PLACE(4, 50_000, "4개 일치 (50,000원)"),
    THIRD_PLACE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND_PLACE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int numberOfMatch;
    private final int prize;
    private final String needToPrint;

    Rank(int numberOfMatch, int prize, String needToPrint) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
        this.needToPrint = needToPrint;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public String getNeedToPrint() {
        return needToPrint;
    }
}
