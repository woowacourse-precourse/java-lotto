package lotto;

public enum LottoRank {
    FIFTH(3,5000,false),
    FOURTH(4,50000,false),
    THIRD(5,1500000,false),
    SECOND(5,30000000,true),
    FIRST(6,2000000000,false);

    Integer hitNumber;
    Integer money;
    Boolean isBonusNeeded;

    LottoRank(Integer hitNumber, Integer money, Boolean isBonusNeeded) {
        this.hitNumber = hitNumber;
        this.money = money;
        this.isBonusNeeded = isBonusNeeded;
    }
}
