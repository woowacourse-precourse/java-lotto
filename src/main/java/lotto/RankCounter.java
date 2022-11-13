package lotto;

import java.util.*;

public class RankCounter {
    private static String FORM_RANK_COUNTER = "%s - $d개";

    private Map<Rank, Integer> rankCounter;

    public RankCounter() {
        rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            System.out.println("rank.getScore() = " + rank.getScore());
            rankCounter.put(rank, 0);
        }
    }

    public void drawLotto(User user, WinningNumbers winningNumbers) {
        Lotto lotto;
        int count;
        Rank rank;
        for (int indexLottos = 0; indexLottos < user.getLottoCount(); indexLottos++) {
            lotto = user.findLotto(indexLottos);
            rank = winningNumbers.rankingLotto(lotto);
            count = rankCounter.getOrDefault(rank, 0);
            rankCounter.put(rank, count + 1);
        }
    }

    public Map<Rank, Integer> getRankCounter() {
        return this.rankCounter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Rank> sortedRank = sortingRank();
        String form;
        for (Rank rank : sortedRank) {
            form = String.format(FORM_RANK_COUNTER, rank.getWinningContent(), rankCounter.get(rank));
            stringBuilder.append(form);
        }
        return stringBuilder.toString();
    }

    private List<Rank> sortingRank() {
        List<Rank> sortedRanks = new ArrayList<>(rankCounter.keySet());
        sortedRanks.sort((rank1, rank2)
                -> rank2.getScore() - rank1.getScore());
        return sortedRanks;
    }
}
