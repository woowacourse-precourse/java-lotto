package lotto.domain;

public class RateCalculator {
    public double CalculateReturnOfRate(int purchaseMoney, int winningMoney){
        double rateMoney = ((double)winningMoney / (double) purchaseMoney) * 100;
        rateMoney = Math.round(rateMoney*100)/100.0;
        return rateMoney;
    }
}
