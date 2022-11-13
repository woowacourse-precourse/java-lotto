package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class PrizeStatistics {
    private final Map<PrizeType, Integer> prizeStatistics = new EnumMap<>(PrizeType.class);

    public PrizeStatistics() {

        for (PrizeType prizeType : PrizeType.values()) {
            prizeStatistics.put(prizeType, 0);
        }
    }

    public int getCount(PrizeType prizeType) {
        return prizeStatistics.get(prizeType);
    }

    public void increment(PrizeType prizeType) {
        prizeStatistics.put(prizeType, prizeStatistics.get(prizeType) + 1);
    }

    public void print() {
        System.out.println("\n당첨 통계\n---");

        for (PrizeType prizeType : prizeStatistics.keySet()) {
            if (prizeType.equals(PrizeType.NONE)) {
                continue;
            }

            System.out.println(prizeType.printNumOfMatched()
                    + prizeType.printPrizeMoney()
                    + " - "
                    + getCount(prizeType)
                    + "개");
        }
    }
}
