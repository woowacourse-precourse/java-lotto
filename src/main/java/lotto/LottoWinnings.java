package lotto;

public enum LottoWinnings {
    LOTTO_UNDER_3_NUMBERS_MATCH(0L),
    LOTTO_3_NUMBERS_MATCH(5_000L),
    LOTTO_4_NUMBERS_MATCH(50_000L),
    LOTTO_5_NUMBERS_MATCH(1_500_000L),
    LOTTO_5_NUMBERS_AND_BONUS_NUMBER_MATCH(30_000_000L),
    LOTTO_6_NUMBERS_MATCH(2_000_000_000L);

    private final Long winnings;

    LottoWinnings(Long winnings) {
        this.winnings = winnings;
    }

    public Long getWinnings() {
        return winnings;
    }

}