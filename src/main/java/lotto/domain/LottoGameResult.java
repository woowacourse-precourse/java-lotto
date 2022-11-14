package lotto.domain;

import java.util.Map;

public class LottoGameResult {
    private final Map<Integer, Integer> winningDetails;
    private final double earningRate;

    public LottoGameResult(Map<Integer, Integer> winningDetails, double earningRate) {
        this.winningDetails = winningDetails;
        this.earningRate = earningRate;
    }

    public Map<Integer, Integer> getWinningDetails() {
        return winningDetails;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
