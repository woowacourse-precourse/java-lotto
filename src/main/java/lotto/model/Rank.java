package lotto.model;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NONE(0,0);

    public static final int RIGHT_BONUS = 1;
    public static final int WRONG_BONUS = 0;

    private final int matchCount;
    private final int priceMoney;

    Rank(int matchNumber, int priceMoney) {
        this.matchCount = matchNumber;
        this.priceMoney = priceMoney;
    }

    public static Rank findByMatchNumber(int number, int checkBonus){
        if(number < FIFTH.matchCount){
            return NONE;
        }else if(number + checkBonus == FIFTH.matchCount){
            return FIFTH;
        }else if(number + checkBonus == FOURTH.matchCount){
            return FOURTH;
        }else if(number == THIRD.matchCount && checkBonus == WRONG_BONUS){
            return THIRD;
        }else if(number == SECOND.matchCount && checkBonus == RIGHT_BONUS){
            return SECOND;
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPriceMoney() {
        return priceMoney;
    }
}
