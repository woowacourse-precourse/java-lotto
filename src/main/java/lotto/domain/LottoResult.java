package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoResult(WinNumbers winNumbers, List<Lotto> lottos) {
        for(Rank rank : Rank.values()) {
            rankCounts.put(rank,0);
        }
        calculateResult(winNumbers, lottos);
    }

    private void calculateResult(WinNumbers winNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(winNumbers,lotto);
            int count = rankCounts.get(rank);
            rankCounts.put(rank, count + 1);
        }
    }

    public Rank calculateRank(WinNumbers winNumbers, Lotto lotto) {
        int count = getWinNumberMatch(winNumbers, lotto);
        if(getWinNumberMatch(winNumbers,lotto) == 5 && includeBonusNumber(winNumbers, lotto)) {
            return Rank.SECOND;
        }
        return getRankByMatch(count);
    }

    private static int getWinNumberMatch(WinNumbers winNumbers, Lotto lotto) {
        int count = 0;
        for (int number : winNumbers.getWinNumbers().getNumbers()) {
            if(lotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static Rank getRankByMatch(int match) {
        for (Rank rank : Rank.values()) {
            if(rank.getMatch() == match) {
                return rank;
            }
        }
        return Rank.OUT;
    }

    public boolean includeBonusNumber(WinNumbers winNumbers, Lotto lotto) {
        return lotto.getNumbers().contains((winNumbers.getBonusNumber()));
    }

    public int getTotalPrize() {
        int prize = 0;
        for (Rank rank : Rank.values()) {
            int count = getCount(rank);
            prize += count * rank.getPrize().getMoney();
        }
        return prize;
    }

    public int getCount(Rank rank) {
        return this.rankCounts.get(rank);
    }


}
