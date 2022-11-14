package lotto;

public enum LottoPrize {
    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    NONE("당첨되지 않음", 0);

    public String matchCount;
    public int reward;

    private LottoPrize(String matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoPrize of(ComparisonToWinningNumberResult result) {
        int matchedNumberCount = result.matchCount;
        boolean bonusMatched = result.isBonusMatched;

        if (matchedNumberCount == 6) {
            return LottoPrize.FIRST;
        }

        if (matchedNumberCount == 5 && bonusMatched) {
            return LottoPrize.SECOND;
        }

        if (matchedNumberCount == 5) {
            return LottoPrize.THIRD;
        }

        if (matchedNumberCount == 4) {
            return LottoPrize.FOURTH;
        }

        if (matchedNumberCount == 3) {
            return LottoPrize.FIFTH;
        }
        return LottoPrize.NONE;
    }
}
