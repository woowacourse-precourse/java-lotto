package lotto;

import java.util.HashMap;
import java.util.Map;

public enum WINNINGS{
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    int value;

    private WINNINGS(int value)
    {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static WINNINGS fromInteger(int correctCount, boolean isBonusCorrect){
        if(correctCount == 3)
            return WINNINGS.FIFTH;

        if(correctCount == 4)
            return WINNINGS.FOURTH;
        if(correctCount == 5) {
            if (isBonusCorrect)
                return WINNINGS.SECOND;
            return WINNINGS.THIRD;
        }

        if(correctCount == 6)
            return WINNINGS.FIRST;

        return null;
    }
}