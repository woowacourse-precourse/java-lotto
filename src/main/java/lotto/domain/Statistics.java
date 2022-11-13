package lotto.domain;


import java.util.HashMap;
import java.util.Map;


public class Statistics {

    public final Map<LottoRank, Integer> winLottoInfo = new HashMap<>();

    private int winAmount;

    public Statistics() {
        initLottoInfoMap();
    }

    private void initLottoInfoMap() {
        for(LottoRank rank : LottoRank.values()) {
            winLottoInfo.put(rank, 0);
        }
    }

    public void setLottoWinResultToMap(int matchCount, int bonusCount) {
        if (matchCount >= 3 && matchCount <= 6) {
            LottoRank rank = LottoRank.of(matchCount, bonusCount);
            winLottoInfo.put(rank, winLottoInfo.get(rank) + 1);
        }
    }

    public int findTotalWinAmount() {
        for (LottoRank rank : winLottoInfo.keySet()) {
            Integer total = winLottoInfo.get(rank);
            winAmount += rank.getMoney(total);
        }
        return winAmount;
    }
}
