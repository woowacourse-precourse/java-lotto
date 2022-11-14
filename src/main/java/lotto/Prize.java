package lotto;

import java.util.Arrays;

public enum Prize {
    NONE(2, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int number;
    private final int prize;

    Prize(int number, int prize){
        this.number=number;
        this.prize=prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getNumber(){
        return number;
    }

    public static Prize findPrize(int number, boolean bonus){
        Prize result = Arrays.stream(Prize.values())
                .filter(x->x.number==number)
                .findFirst()
                .orElse(NONE);
        if(result==THIRD&&bonus){
            result=SECOND;
        }
        return result;
    }
}
