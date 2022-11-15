package lotto.domain;

import java.util.Map;

public class GameScore {

    private int prizeMoney;
    private double profitRate;
    private Map<LottoWinType, Integer> lottoWinType;

    public GameScore(int prizeMoney, double profitRate, Map<LottoWinType, Integer> lottoWinType) {
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

    private static double calculateProfitRate(int prizeMoney, int userPay) {
        return (double) prizeMoney / (double) userPay * 100;
    }

    public static GameScore of(int prizeMoney, int userPay, Map<LottoWinType, Integer> lottoWinType) {
        double profitRate = calculateProfitRate(prizeMoney, userPay);
        return new GameScore(prizeMoney, profitRate, lottoWinType);
    }
}
