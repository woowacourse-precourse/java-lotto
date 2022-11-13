package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.Constants;

public class PrizeData {
    private final Map<Integer, Integer> prizeCount;

    PrizeData() {
        prizeCount = new HashMap<>();
        putInitialPrizeData();
    }

    private void putInitialPrizeData() {
        for (int prizeNumber = Constants.FIRST_PRIZE; prizeNumber <= Constants.END_PRIZE; prizeNumber++) {
            prizeCount.put(prizeNumber, Constants.INITIAL_DATA_FOR_PRIZE_COUNT);
        }
    }

    void addPrizeCount(int prizeNumber) {
        prizeCount.merge(prizeNumber, 1, Integer::sum);
    }

    public Map<Integer, Integer> getPrizeCount() {
        return prizeCount;
    }
}
