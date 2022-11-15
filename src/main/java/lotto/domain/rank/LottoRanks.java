package lotto.domain.rank;

import java.util.HashMap;
import java.util.Map;


public class LottoRanks {
    private final Map<LottoRank, Long> rankInfos;

    public LottoRanks(Map<LottoRank, Long> rankInfos) {
        this.rankInfos = rankInfos;
    }

    public int findTotalWinAmount() {
        return rankInfos.keySet()
                .stream()
                .mapToInt(rank -> rank.findTotalMoney(rankInfos.get(rank).intValue()))
                .sum();
    }

    public Map<LottoRank, Long> getWinLottoInfoMap() {
        return new HashMap<>(rankInfos);
    }
}