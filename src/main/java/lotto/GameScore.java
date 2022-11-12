package lotto;

import java.util.Map;

public class GameScore {

    private int prizeMoney;
    private double profitRate;
    private Map<LottoWinType, Integer> lottoWinType;

    public GameScore(int prizeMoney, Map<LottoWinType, Integer> lottoWinType) {
        this.prizeMoney = prizeMoney;
        this.lottoWinType = lottoWinType;
        this.profitRate = 0;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(int userPay) {
        this.profitRate = (double) this.prizeMoney / (double) userPay * 100;
    }

    public Map<LottoWinType, Integer> getLottoWinType() {
        return lottoWinType;
    }
}
