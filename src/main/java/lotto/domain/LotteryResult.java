package lotto.domain;

import lotto.constant.LotteryRank;
import lotto.constant.Status;
import lotto.domain.constant.LottoProperty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LotteryResult {
    private static final int UNIT = 1;

    private Map<LotteryRank, Integer> result;
    private Set<String> rankedTicketIds;
    private long totalReward;
    private int size;

    public LotteryResult() {
        result = new HashMap<>();
        rankedTicketIds = new HashSet<>();
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

    public void add (String id, LotteryRank rank) {
        result.put(rank, result.get(rank) + UNIT);
        rankedTicketIds.add(id);
        totalReward += rank.getReward();
        size++;
    }

    public Map<LotteryRank, Integer> findWinningInformation() {
        Map<LotteryRank, Integer> winningInformation = new HashMap<>();
        for (LotteryRank rank : LotteryRank.values()) {
            if (rank.getNumberOfMatches() < LottoProperty.MIN_WINNING_MATCHES.getProperty()) {
                continue;
            }
            winningInformation.put(rank, result.get(rank));
        }
        return winningInformation;
    }

    public int findByRank (LotteryRank rank) {
        return result.get(rank);
    }

    public boolean hasTicket (String id) {
        return rankedTicketIds.contains(id);
    }

    public int getSize() {
        return size;
    }

    public long getTotalReward() {
        return totalReward;
    }
}