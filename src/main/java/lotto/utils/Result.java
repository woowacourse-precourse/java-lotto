package lotto.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Result {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    OUT(0,0);

    private int reward;
    private int winCount;

    Result(final int winCount, final int reward){
        this.reward = reward;
        this.winCount = winCount;
    }

    public static Result getResult(final int winCount, final boolean containBonusNumber){
        if(winCount < FIFTH.winCount){
            return OUT;
        }
        if(winCount == THIRD.winCount && !containBonusNumber){
            return THIRD;
        }

        return Arrays.stream(values()).filter(rating -> rating.winCount == winCount).findAny()
                .orElseThrow(NoSuchElementException::new);
    }



}
