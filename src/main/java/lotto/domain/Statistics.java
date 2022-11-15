package lotto.domain;


import java.util.HashMap;
import java.util.Map;


public class Statistics {

    private static final int PERCENTAGE = 100;

    public final Map<LottoRank, Integer> winLottoInfo = new HashMap<>();

    private int winAmount;

    public Statistics() {

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
