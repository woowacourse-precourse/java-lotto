package lotto.domain;

import static lotto.io.Message.LF;
import static lotto.io.Message.RESULT;

import java.util.Map;

public class StatResult {

    private final long input;
    private final long output;
    private final double rateOfReturn;
    private final Map<Grade, Integer> result;

    public StatResult(long input, Map<Grade, Integer> result) {
        this.input = input;
        this.result = result;
        this.output = calculateOutput(result);
        this.rateOfReturn = calculateRate();
    }

    private long calculateOutput(Map<Grade, Integer> result) {
        long totalPrize = 0;

        for (Map.Entry<Grade, Integer> grade : result.entrySet()) {
            totalPrize += ((long) grade.getKey().getPrizeMoney() * grade.getValue());
        }

        return totalPrize;
    }

    private double calculateRate() {
        double rate = ((double) output / input) * 100;
        return Math.round(rate * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Grade, Integer> grade : result.entrySet()) {
            sb.append(grade.getKey())
              .append(" - ")
              .append(grade.getValue())
              .append("개")
              .append(LF);
        }

        sb.append(String.format(RESULT, rateOfReturn));

        return sb.toString();
    }

}
