package lotto;

public enum LottoResult {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NOTHING("꽝", 0);

    private final String details;
    private final int prize;

    LottoResult(String details, int prize) {
        this.details = details;
        this.prize = prize;
    }

    public String getDetails() {
        return details;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoResult checkRanking(int correct, boolean bonus) {
        if (correct == 6) {
            return LottoResult.FIRST;
        }
        if (correct == 5) {
            if (bonus) {
                return LottoResult.SECOND;
            }
            return LottoResult.THIRD;
        }
        if (correct == 4) {
            return LottoResult.FOURTH;
        }
        if (correct == 3) {
            return LottoResult.FIFTH;
        }
        return LottoResult.NOTHING;
    }
}
