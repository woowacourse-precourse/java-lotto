package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    FAIL(0, -1, false);

    private int reward;

    public int getReward() {
        return reward;
    }

    public int getCorrectNums() {
        return correctNums;
    }

    public boolean isBonusNumCheck() {
        return bonusNumCheck;
    }

    private int correctNums;
    private boolean bonusNumCheck;

    Ranking(int reward, int correctNums, boolean bonusNumCheck) {
        this.reward = reward;
        this.correctNums = correctNums;
        this.bonusNumCheck = bonusNumCheck;
    }

    private static Ranking findRank(int correctCount,boolean bonusNum){
        if(correctCount == 5){

        }
        return Arrays.stream(Ranking.values())
                .filter( r -> r.getCorrectNums() == correctCount)
                .findFirst()
                .orElse(FAIL);
    }


}
