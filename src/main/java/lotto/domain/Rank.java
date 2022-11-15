package lotto.domain;

public enum Rank {
    FIRST_SIX_MATCHED(2_000_000_000),
    SECOND_FIVE_WITH_BONUS(30_000_000),
    THIRD_FIVE_MATCHED(1_500_000),
    FOURTH_FOUR_MATCHED(50_000),
    FIFTH_THREE_MATCHED(5_000);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
