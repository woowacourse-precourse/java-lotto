package domain;

public enum LottoRank {
    MISS(0,0),
    FIFTH(3,5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6,2000000000);

    public Integer hitNumber;
    public Integer money;

    LottoRank(Integer hitNumber, Integer money) {
        this.hitNumber = hitNumber;
        this.money = money;
    }

    public static LottoRank decideRank(Integer hit, boolean bonusHit){
        if (bonusHit)
            return SECOND;
        for(LottoRank rank : LottoRank.values()){
            if(rank.hitNumber==hit)
                return rank;
        }
        return MISS;
    }
}
