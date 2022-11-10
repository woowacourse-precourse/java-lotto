package lotto.domain;

public enum LottoRank {
    FIRST(new ComparedNumber(6,false)),
    SECOND(new ComparedNumber(5,true)),
    THIRD(new ComparedNumber(5,false)),
    FOURTH(new ComparedNumber(4,false)),
    FIFTH(new ComparedNumber(3,false)),
    NONE(new ComparedNumber(0,false));

    private final ComparedNumber comparedNumber;

    LottoRank(ComparedNumber comparedNumber) {
        this.comparedNumber = comparedNumber;
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
}
