package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000,true),
    THIRD(5,1500000,false),
    FOURTH(4,50000,false),
    FIFTH(3,5000,false),
    OUTRANK(0,0,false);


    private final int matchingCnt;
    private final int reward;
    private final boolean bonusBall;

    Rank(int matchingCnt, int reward, boolean bonusBall) {
        this.matchingCnt = matchingCnt;
        this.reward = reward;
        this.bonusBall = bonusBall;
    }

    public Rank getRank(int matchingCnt, boolean bonusBall){
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCnt == matchingCnt)
                .filter(rank -> rank.bonusBall == bonusBall)
                .findFirst()
                .orElse(OUTRANK);
    }

    public int getMatchingCnt() {
        return matchingCnt;
    }

    public int getReward() {
        return reward;
    }

    public boolean isBonusBall() {
        return bonusBall;
    }
}
