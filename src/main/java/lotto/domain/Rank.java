package lotto.domain;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private int count;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        this.count += 1;
    }
}
