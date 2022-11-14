package lotto.domain;

import java.util.HashMap;
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

    private Map<Rank, Integer> rankPrize = new HashMap<>() {{
        put(FIRST_PLACE, 2_000_000_000);
        put(SECOND_PLACE, 30_000_000);
        put(THIRD_PLACE, 1_500_000);
        put(FOURTH_PLACE, 50_000);
        put(FIFTH_PLACE, 5_000);
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
