package lotto.model;

import java.util.Arrays;

public enum Ranking {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
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

    public static Ranking findRank(int correctCount,boolean bonusNumCheck){
        if(correctCount == 5){
            decideSecondOrThird(bonusNumCheck);
        }
        return Arrays.stream(Ranking.values())
                .filter( r -> r.getCorrectNums() == correctCount)
                .findFirst()
                .orElse(FAIL);
    }



    private static Ranking decideSecondOrThird(boolean bonusNumCheck){
        if(bonusNumCheck) return SECOND;
        return THIRD;
    }
}
