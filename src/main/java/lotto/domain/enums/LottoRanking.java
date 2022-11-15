package lotto.domain.enums;

public enum LottoRanking {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FOURTH(50000L),
    FIFTH(5000L);

    private final long winnings;

    LottoRanking(long winnings) {
        this.winnings = winnings;
    }

    public Long getWinnings() {
        return winnings;
    }
}