package lotto.domain;

import static lotto.Constant.LOTTO_PRICE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.NumberFormatter;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void record(Integer duplicatedCnt, boolean hasBonusNumber) {
        Rank rank = Rank.valueOf(duplicatedCnt, hasBonusNumber);
        result.put(rank, result.get(rank) + 1);
    }

    @Override
    public String toString() {
        List<String> messages = new ArrayList<>();
        // TODO 순서 보장되는 Map 있었음. 해당 방식 찾아보기 (NOTHING뺴고 돌려야함)
        messages.add(Rank.FIFTH + " - " + NumberFormatter.format(result.get(Rank.FIFTH)) + "개");
        messages.add(Rank.FOURTH + " - " + NumberFormatter.format(result.get(Rank.FOURTH)) + "개");
        messages.add(Rank.THIRD + " - " + NumberFormatter.format(result.get(Rank.THIRD)) + "개");
        messages.add(Rank.SECOND + " - " + NumberFormatter.format(result.get(Rank.SECOND)) + "개");
        messages.add(Rank.FIRST + " - " + NumberFormatter.format(result.get(Rank.FIRST)) + "개");
        return String.join("\n", messages);
    }

    public Double calculateYield() {
        Integer totalOutcome = 0;
        Integer totalInput = 0;
        for (Rank rank : result.keySet()) {
            Integer rankCnt = result.get(rank);
            totalOutcome += rank.getMoney() * rankCnt;
            totalInput += LOTTO_PRICE * rankCnt;
        }
        return Double.valueOf(totalOutcome) / totalInput * 100;
    }


}