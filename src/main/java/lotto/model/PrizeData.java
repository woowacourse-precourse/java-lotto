package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeData {
    private final Map<Integer, Integer> prize;

    PrizeData() {
        prize = new HashMap<>();
        putInitialPrizeData();
    }

    void putInitialPrizeData() {
        int END_PRIZE = 5;
        int START_PRIZE = 1;
        for (int initialData = START_PRIZE; initialData <= END_PRIZE; initialData++) {
            prize.put(initialData, 0);
        }
    }

    public void addPrizeCount(int prizeNumber) {
        prize.merge(prizeNumber, 1, Integer::sum);
    }

    public Map<Integer, Integer> getPrize() {
        return prize;
    }
}
