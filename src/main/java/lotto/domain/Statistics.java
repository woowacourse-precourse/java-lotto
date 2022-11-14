package lotto.domain;

import java.util.Map;
import java.util.TreeMap;

import static lotto.domain.Rank.*;

public class Statistics {
    private Map<Rank, Integer> rankRecord = new TreeMap<>() {{
        put(FIRST_PLACE, 0);
        put(SECOND_PLACE, 0);
        put(THIRD_PLACE, 0);
        put(FOURTH_PLACE, 0);
        put(FIFTH_PLACE, 0);
        put(UNRANK, 0);
    }};

    public void record(Rank rank) {
        rankRecord.put(rank, rankRecord.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankRecord() {
        return rankRecord;
    }

    private int calculateNumberOfLottosPaid() {
        return rankRecord.values().stream()
                .mapToInt(count -> count)
                .sum();
    }
}
