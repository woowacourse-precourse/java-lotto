package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.NumberFormatter;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new HashMap<>();
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.NOTHING, 0);
    }

    public void record(Integer duplicatedCnt, boolean hasBonusNumber) {
        Rank rank = Rank.valueOf(duplicatedCnt, hasBonusNumber);
        result.put(rank, result.get(rank) + 1);
    }

    @Override
    public String toString() {
        List<String> messages = new ArrayList<>();
        messages.add(Rank.FIFTH + " - " + NumberFormatter.format(result.get(Rank.FIFTH)) + "개");
        messages.add(Rank.FOURTH + " - " + NumberFormatter.format(result.get(Rank.FOURTH)) + "개");
        messages.add(Rank.THIRD + " - " + NumberFormatter.format(result.get(Rank.THIRD)) + "개");
        messages.add(Rank.SECOND + " - " + NumberFormatter.format(result.get(Rank.SECOND)) + "개");
        messages.add(Rank.FIRST + " - " + NumberFormatter.format(result.get(Rank.FIRST)) + "개");
        return String.join("\n", messages);
    }

    public double calculateYield() {
        Integer totalOutcome = 0;
        Integer totalInput = 0;
        for(int i=0; i<result.size();i++ ){
            totalOutcome += result.get(i) * money.get(i);
            totalInput += result.get(i) * 1000;
        }

        double yield = ((double) totalOutcome / totalInput) * 100;
        return Math.round(yield * 100) / 100.0;
    }
}
