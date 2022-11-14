package lotto.domain;

public enum LottoRanking {
    SIX_RIGHT("6개 일치 (2,000,000,000원)", 2000000000),
    FIVE_AND_BONUS_RIGHT("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    FIVE_RIGHT("5개 일치 (1,500,000원)",1500000),
    FOUR_RIGHT("4개 일치 (50,000원)", 50000),
    THREE_RIGHT("3개 일치 (5,000)", 5000);

    private final String message;
    private final int prizeMoney;

    LottoRanking(String message, int prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }
}
