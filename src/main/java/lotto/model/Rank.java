package lotto.model;

public enum Rank {
    FIRST(6, 0, 2000000000, 1),
    SECOND(5, 1, 30000000, 2),
    THIRD(5, 0, 1500000, 3),
    FOURTH(4, 0, 50000, 4),
    FIFTH(3, 0, 5000, 5),
    NONE(0, 0, 0, 0);


    private Integer matchedCount;
    private Integer bonusCount;
    private Integer amount;
    private Integer toInteger;

    Rank(Integer matchedCount, Integer bonusCount, Integer amount, Integer toInteger){
        this.matchedCount = matchedCount;
        this.bonusCount = bonusCount;
        this.amount = amount;
        this.toInteger = toInteger;
    }

}
