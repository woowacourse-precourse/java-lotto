package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoRank {
    private final Map<Integer, Integer> totalRank;

    public LottoRank() {
        Map<Integer, Integer> totalRank = new HashMap<>();
        initializeTotalRank(totalRank);
        this.totalRank = totalRank;
    }

    public LottoRank addRank(LottoRank rank, int winRank) {
        if (winRank == 0)
            return rank;
        int count = totalRank.get(winRank);
        totalRank.put(winRank, count + 1);
        return rank;
    }

    private Map<Integer, Integer> initializeTotalRank(Map<Integer, Integer> totalRank) {
        for (int rank = 1; rank <= 5; rank++) {
            totalRank.put(rank, 0);
        }
        return totalRank;
    }
}
