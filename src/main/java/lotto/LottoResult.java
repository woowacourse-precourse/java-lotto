package lotto;

public enum LottoResult {
    None(-1, false, "꽝", 0),
    Match3(3, false, "3개 일치 (5,000원)", 5_000),
    Match4(4, false, "4개 일치 (50,000원)", 50_000),
    Match5(5, false, "5개 일치 (1,500,000원)", 1_500_000),
    Match5AndBonus(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    Match6(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000);

    public static LottoResult find(int matchCount, boolean bonus) {

        for(LottoResult result : values()) {
            if(result.matchCount == matchCount && result.bonus == bonus) {
                return result;
            }
        }

        return None;
    }

    private final int matchCount;
    private final boolean bonus;
    private final String msg;
    private final long amount;

    LottoResult(int matchCount, boolean bonus, String msg, long amount) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.msg = msg;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return msg;
    }

    public long getAmount() {
        return amount;
    }

}
