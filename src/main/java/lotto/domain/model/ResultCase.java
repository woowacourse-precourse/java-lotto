package lotto.domain.model;

public enum ResultCase {

    THREE_MATCHES(5000),
    FOUR_MATCHES(50000),
    FIVE_MATCHES(1500000),
    FIVE_BONUS_MATCHES(30000000),
    SIX_MATCHES(2000000000);

    private final Integer prizeMoney;
    ResultCase(final Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
