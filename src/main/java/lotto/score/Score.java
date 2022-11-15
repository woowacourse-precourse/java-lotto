package lotto.score;

import java.util.Map;

public class Score {
    private final Map<Grade, Integer> grade;
    private final double rewardPercentage;

    public Score(Map<Grade, Integer> grade, double rewardPercentage) {
        this.grade = grade;
        this.rewardPercentage = rewardPercentage;
    }

    public Map<Grade, Integer> getGrade() {
        return this.grade;
    }

    public double getRewardPercentage() {
        return rewardPercentage;
    }

}
