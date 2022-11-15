package lotto.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum RewardType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchNum;
    private int reward;

    RewardType(int matchNum, int reward){
        this.matchNum = matchNum;
        this.reward = reward;
    }

    public int getNum() {
        return matchNum;
    }

    public int getReward(){
        return reward;
    }

    public static RewardType getRating(int matchNum, boolean containBonusBall){
        if (matchNum == THIRD.matchNum && !containBonusBall){
            return THIRD;
        }
        if (matchNum < FIFTH.matchNum){
            return MISS;
        }
        return Arrays.stream(values()).filter(rating -> rating.matchNum == matchNum).findAny()
                .orElseThrow(NoSuchElementException::new);
    }

}
