package lotto.service;

public class RewardService {

    public static double calculateRateOfReturn(int purchaseAmount, int reward) {
        double rateOfReturn = ((double)reward / purchaseAmount) * 100 - 100;
        return Math.round((rateOfReturn * 10) / 10.0);
    }
}
