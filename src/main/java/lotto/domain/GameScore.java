package lotto.domain;

import java.util.Map;
import lotto.domain.LottoWinType;

public class GameScore {

    private int prizeMoney;
    private double profitRate;
    private Map<LottoWinType, Integer> lottoWinType;

    public GameScore(int prizeMoney, int profitRate, Map<LottoWinType, Integer> lottoWinType) {
        this.prizeMoney = prizeMoney;
        this.profitRate = profitRate;
        this.lottoWinType = lottoWinType;
    }

    public int getPrizeMoney() { return prizeMoney; }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<LottoWinType, Integer> getLottoWinType() {
        return lottoWinType;
    }

    public static GameScore of(int prizeMoney, int profitRate, Map<LottoWinType, Integer> lottoWinType) {
        return new GameScore(prizeMoney, profitRate, lottoWinType);
    }
}
