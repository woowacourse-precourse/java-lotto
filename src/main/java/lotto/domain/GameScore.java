package lotto.domain;

import java.util.Map;

public class GameScore {

    private int winMoney;
    private double profitRate;
    private static Map<LottoWinType, Integer> lottoWinTypeMap;

    public GameScore(int winMoney, double profitRate, Map<LottoWinType, Integer> lottoWinTypeMap) {
        this.winMoney = winMoney;
        this.profitRate = profitRate;
        this.lottoWinTypeMap = lottoWinTypeMap;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<LottoWinType, Integer> getLottoWinType() {
        return lottoWinTypeMap;
    }

    public static GameScore of(int winMoney, int userPay, Map<LottoWinType, Integer> lottoWinType) {
        double profitRate = calculateProfitRate(winMoney, userPay);
        return new GameScore(winMoney, profitRate, lottoWinType);
    }

    private static double calculateProfitRate(int price, int userPay) {
        double result = (double) price / (double) userPay * 100;
        return result;
    }
}
