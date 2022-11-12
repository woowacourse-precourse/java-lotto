package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class PrizeStatistics {
    private final Map<PrizeType, Integer> prizeStatistics =
            new EnumMap<PrizeType, Integer>(PrizeType.class);

    public PrizeStatistics() {

        for (PrizeType prizeType : PrizeType.values()) {
            prizeStatistics.put(prizeType, 0);
        }
    }

    public void increment(PrizeType prizeType) {
        prizeStatistics.put(prizeType, prizeStatistics.get(prizeType) + 1);
    }

    public int getCount(PrizeType prizeType) {
        return prizeStatistics.get(prizeType);
    }
}
