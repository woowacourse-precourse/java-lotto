package lotto.domain;


import java.util.HashMap;
import java.util.Map;


public class Statistics {

    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_VALUE = 1;
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;
    private static final int PERCENTAGE = 100;

    public final Map<LottoRank, Integer> winLottoInfo = new HashMap<>();

    private int winAmount;

    public Statistics() {
        initLottoInfoMap();
    }

    private void initLottoInfoMap() {
        for(LottoRank rank : LottoRank.values()) {
            winLottoInfo.put(rank, DEFAULT_VALUE);
        }
    }

    public void setLottoWinResultToMap(int matchCount, int bonusCount) {
        if (matchCount >= MIN_MATCH_COUNT && matchCount <= MAX_MATCH_COUNT) {
            LottoRank rank = LottoRank.of(matchCount, bonusCount);
            winLottoInfo.put(rank, winLottoInfo.get(rank) + PLUS_VALUE);
        }
    }

    public int findTotalWinAmount() {
        for (LottoRank rank : winLottoInfo.keySet()) {
            Integer total = winLottoInfo.get(rank);
            winAmount += rank.findTotalMoney(total);
        }
        return winAmount;
    }

    public double findLottoYield(int purchaseAmount) {
        double quotient = (double) winAmount / (double) purchaseAmount;
        return quotient * PERCENTAGE;
    }

    public Map<LottoRank, Integer> getWinLottoInfoMap() {
        return new HashMap<>(winLottoInfo);
    }
}
