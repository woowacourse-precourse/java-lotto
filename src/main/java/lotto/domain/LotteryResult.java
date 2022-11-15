package lotto.domain;

import lotto.constant.LotteryRank;
import lotto.constant.Status;

import java.util.HashMap;
import java.util.Map;

public class LotteryResult {
    private static final int UNIT = 1;

    private Map<LotteryRank, Integer> result;
    private long totalReward;
    private int size;

    public LotteryResult() {
        result = new HashMap<>();
        initResult();
        totalReward = 0;
        size = 0;
    }

    private void initResult() {
        for (LotteryRank rank : LotteryRank.values()) {
            if (rank == LotteryRank.BEFORE_DRAW) {
                continue;
            }
            result.put(rank, Status.EMPTY.getStatus());
        }
    }

    public void add (LotteryRank rank) {
        result.put(rank, result.get(rank) + UNIT);
        totalReward += rank.getReward();
        size++;
    }

    public int findByRank (LotteryRank rank) {
        return result.get(rank);
    }

    public int getSize() {
        return size;
    }

    public long getTotalReward() {
        return totalReward;
    }
}