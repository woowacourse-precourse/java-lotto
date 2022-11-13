package lotto.domain;

public enum Winning {

    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L);

    private final Long winnings;

    Winning(Long winnings) {
        this.winnings = winnings;
    }

    public Long getWinnings() {
        return this.winnings;
    }

}
