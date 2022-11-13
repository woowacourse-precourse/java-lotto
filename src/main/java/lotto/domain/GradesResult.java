package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class GradesResult {

    private final Map<Grade, Integer> gradesResult;

    public GradesResult(Map<Grade, Integer> gradesResult) {
        this.gradesResult = gradesResult;
    }

    public Map<Grade, Integer> getGradesResult() {
        return Collections.unmodifiableMap(gradesResult);
    }

    public double calculateYield(Money money) {
        return getTotalPrizeMoney() / money.getMoney();
    }

    private double getTotalPrizeMoney() {
        return gradesResult.keySet().stream()
                .mapToDouble(grade -> getPrizeMoney(grade))
                .sum();
    }

    private int getPrizeMoney(Grade grade) {
        return grade.getPrizeMoney().getMoney() * gradesResult.get(grade);
    }
}
