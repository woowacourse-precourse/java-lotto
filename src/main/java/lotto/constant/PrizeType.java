package lotto.constant;

public enum PrizeType {

    THREE_MATCHES_PRIZE(5_000),
    FOUR_MATCHES_PRIZE(50_000),
    FIVE_MATCHES_WITHOUT_BONUS_PRIZE(1_500_000),
    FIVE_MATCHES_WITH_BONUS_PRIZE(30_000_000),
    SIX_MATCHES_PRIZE(2_000_000_000);

    private final Integer prize;

    PrizeType(Integer prize) {
        this.prize = prize;
    }

    public Integer getPrize() {
        return this.prize;
    }
}
