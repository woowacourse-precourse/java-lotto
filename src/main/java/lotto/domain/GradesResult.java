package lotto.domain;

import java.util.Map;

public class GradesResult {

    private final Map<Grade, Integer> gradeResult;

    public GradesResult(Map<Grade, Integer> gradeResult) {
        this.gradeResult = gradeResult;
    }

    public Map<Grade, Integer> getGradeResult() {
        return gradeResult;
    }

    public double calculateYield(Money money) {
        return getTotalPrizeMoney() / money.getMoney();
    }

    private double getTotalPrizeMoney() {
        return gradeResult.keySet().stream()
                .mapToDouble(i -> i.getPrizeMoney().getMoney() * gradeResult.get(i))
                .sum();
    }
}
