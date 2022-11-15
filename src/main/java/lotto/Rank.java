package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    Failure(0, 0);


    private int currentNumber;
    private int reward;

    Rank(int currentNumber, int reward){
        this.currentNumber = currentNumber;
        this.reward = reward;
    }

    public Rank setRank(int currentNumber, boolean hasBonusNumber){
        Rank currentRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameNumber(currentNumber))
                .filter(rank -> !rank.equals(SECOND) || hasBonusNumber)
                .findFirst()
                .orElse(Failure);

        return currentRank;
    }

    public boolean isSameNumber(int currentNumber){
        return this.currentNumber == currentNumber;
    }

    public int getReward(){
        return reward;
    }
}
