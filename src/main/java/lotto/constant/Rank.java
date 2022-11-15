package lotto.constant;

public enum Rank {
    FIRST_SIX_MATCHED(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND_FIVE_WITH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_FIVE_MATCHED(1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH_FOUR_MATCHED(50_000, "4개 일치 (50,000원)"),
    FIFTH_THREE_MATCHED(5_000, "3개 일치 (5,000원)");

    private final int prize;
    private final String message;

    Rank(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return message;
    }
}
