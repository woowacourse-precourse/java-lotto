package lotto;

public enum Prize {
    FIRST(2000000000000L),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    final long cashPrize;

    Prize(long cash) {
        this.cashPrize = cash;
    }
}
