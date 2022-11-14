package lotto;

public enum LottoPlace {

    MATCHED_6(2_000_000_000),
    MATCHED_5_WITH_BONUS(30_000_000),
    MATCHED_5(1_500_000),
    MATCHED_4(50_000),
    MATCHED_3(5_000),
    NONE(0);

    private final int prizeMoney;

    LottoPlace(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
