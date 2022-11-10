package lotto;

public enum LottoResult {

    ELSE(0),
    THREE( 5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(30_000_000),
    FIVE_WITH_BONUS(2_000_000_000);

    private int payout;

    LottoResult(int payout) {
        this.payout = payout;
    }
}
