package lotto.domain;

public enum LottoRank {
    NONE_MATCH(0, "", 0),
    THREE_MATCHES(3, "3개 일치 (5,000원) - ", 5_000),
    FOUR_MATCHES(4, "4개 일치 (50,000원) - ", 50_000),
    FIVE_MATCHES(5, "5개 일치 (1,500,000원) - ", 1_500_000),
    FIVE_BONUS_MATCHES(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    ALL_MATCHES(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final int ranking;
    private final String message;
    private final int money;

    LottoRank(int ranking, String message, int money) {
        this.ranking = ranking;
        this.message = message;
        this.money = money;
    }

    public String getMessage() {
        return message;
    }

    public int getMoney() {
        return money;
    }

    public static LottoRank getRankResult(int winningCount, boolean bonus) {
        if (FIVE_BONUS_MATCHES.ranking == winningCount && bonus) {
            return FIVE_BONUS_MATCHES;
        }
        for (LottoRank rank : values()) {
            if (rank.ranking == winningCount && rank != FIVE_BONUS_MATCHES) {
                return rank;
            }
        }
        return NONE_MATCH;
    }
}
