package lotto.model;

import java.util.*;

public class RankCounter {
    private static String FORM_RANK_COUNTER = "%s - %d개\n";

    private Map<Rank, Integer> rankCounter;

    public RankCounter() {
        rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        int count = rankCounter.get(rank);
        rankCounter.put(rank, count + 1);
    }

    public int countRank(Rank rank) {
        return rankCounter.get(rank);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Rank> sortedRank = Rank.getSortRanks();
        String form;
        Rank rank;
        for (int rankIndex = 1; rankIndex < sortedRank.size(); rankIndex++) {
            rank = sortedRank.get(rankIndex);
            form = String.format(FORM_RANK_COUNTER, rank.getWinningContent(), rankCounter.get(rank));
            stringBuilder.append(form);
        }
        return stringBuilder.toString();
    }
}
