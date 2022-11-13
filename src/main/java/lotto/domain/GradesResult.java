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

    public double calculateYield(LottoMoney money) {
        return calculateTotalPrizeMoney() / money.getMoney();
    }

    private double calculateTotalPrizeMoney() {
        return gradesResult.keySet().stream()
                .mapToDouble(grade -> calculatePrizeMoney(grade))
                .sum();
    }

    private long calculatePrizeMoney(Grade grade) {
        return grade.getPrizeMoney().getMoney() * gradesResult.get(grade);
    }
}
