package lotto.domain;

import java.util.Map;

public class Statistics {
    private Map<Grade, Integer> gradeCount;
    private float earningRate;

    public Statistics(Map<Grade, Integer> gradeCount, float earningRate) {
        this.gradeCount = gradeCount;
        this.earningRate = earningRate;
    }

    public Map<Grade, Integer> getGradeCount() {
        return gradeCount;
    }

    public float getEarningRate() {
        return earningRate;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        Grade[] grades = Grade.values();
        for (int i = grades.length - 2; i >= 0; i--) {
            sb.append(grades[i] + " - " + gradeCount.get(grades[i]) + Unit.NUMBER + "\n");
        }

        sb.append(String.format("총 수익률은 %.1f%%입니다.", earningRate));

        return sb.toString();
    }


}
