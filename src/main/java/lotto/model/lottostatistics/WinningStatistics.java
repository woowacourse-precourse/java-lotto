package lotto.model.lottostatistics;

import java.util.Map;
import java.util.Map.Entry;

public class WinningStatistics {

    public final Map<Ranking, Long> rankBoard;

    WinningStatistics(Map<Ranking, Long> rankBoard) {
        this.rankBoard = rankBoard;
    }

    public long getRewardSum() {
        long rewardSum = 0;
        for (Entry<Ranking, Long> entrySet : rankBoard.entrySet()) {
            long rank = entrySet.getKey().getPrize();
            long count = entrySet.getValue();
            rewardSum += rank * count;
        }

        return rewardSum;
    }
}
