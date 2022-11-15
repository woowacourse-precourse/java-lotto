package lotto;

public enum LottoPlace {

    FIRST("6개 일치", 2_000_000_000, 6, false),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000, 5, true),
    THIRD("5개 일치", 1_500_000, 5, false),
    FORTH("4개 일치", 50_000, 4, false),
    FIFTH("3개 일치", 5_000, 3, false),
    NONE("해당 없음", 0, 0, false);

    private final String info;
    private final int prizeMoney;
    private final int matchCount;
    private final boolean bonusCheck;

    LottoPlace(String info, int prizeMoney, int matchCount, boolean bonusCheck) {
        this.info = info;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonusCheck = bonusCheck;
    }

    public String getInfo() {
        return info;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusCheck() {
        return bonusCheck;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
