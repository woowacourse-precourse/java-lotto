package model;

import java.util.Arrays;

public enum Result {
    THREE("5,000원",5000,3,false),
    FOUR("50,000원", 50000,4,false),
    FIVE("1,500,000원",1500000,5,false),
    FIVE_BONUS("30,000,000원",30000000,5,true),
    SIX("2,000,000,000원",2000000000,6,false),
    LOST("0원", 0, 0, false),
    ;
    
    private final String price;
    private final int priceNum;
    private final int coincideCount;
    private final boolean bonus;

    Result(String price, int priceNum, int coincideCount,boolean bonus) {
        this.price = price;
        this.priceNum = priceNum;
        this.coincideCount = coincideCount;
        this.bonus = bonus;
    }


    public static Result getResult(int coincideCount,boolean bonus) {
        return Arrays.stream(values())
                .filter(value -> value.isMatch(coincideCount,bonus))
                .findAny()
                .orElse(LOST);
    }

    private boolean isMatch(int coincideCount, boolean bonus) {
        if (isSameCountAndBonus(coincideCount,bonus)) {
            return true;
        }
        return false;
    }

    private boolean isSameCountAndBonus(int coincideCount, boolean bonus) {
        return this.coincideCount == coincideCount && this.bonus == bonus;
    }

    public int getPriceNum() {
        return priceNum;
    }
}
