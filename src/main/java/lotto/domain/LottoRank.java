package lotto.domain;

public enum LottoRank {
    FIRST(new ComparedNumber(6,false),2_000_000_000),
    SECOND(new ComparedNumber(5,true),30_000_000),
    THIRD(new ComparedNumber(5,false),1_500_000),
    FOURTH(new ComparedNumber(4,false),50_000),
    FIFTH(new ComparedNumber(3,false),5000),
    NONE(new ComparedNumber(0,false),0);

    private final ComparedNumber comparedNumber;
    private final int reward;

    LottoRank(ComparedNumber comparedNumber, int reward) {
        this.comparedNumber = comparedNumber;
        this.reward = reward;
    }

    public static LottoRank getRank(ComparedNumber comparedNumber){
        for (LottoRank lottoResult : LottoRank.values()) {
            if (lottoResult.comparedNumber.equals(comparedNumber)) {
                return lottoResult;
            }
        }
        return NONE;
    }

    public boolean isWin() {
        return this != NONE;
    }

    public int calculateSubReturn(int count) {
        return this.reward * count;
    }
}
