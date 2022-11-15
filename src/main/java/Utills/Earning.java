package Utills;

import Winning.WinningHistory;

public class Earning {

    private static final double firstPrize = 2_000_000_000;
    private static final double secondPrize = 30_000_000;
    private static final double thirdPrize = 1_500_000;
    private static final double forthPrize = 50_000;
    private static final double fifthPrize = 5000;

    public double calculate(int sameCmt, int bonusCorrect) {
        if (sameCmt == 6) return firstPrize;
        if (sameCmt == 5 && bonusCorrect == 1) return secondPrize;
        if (sameCmt == 5) return thirdPrize;
        if (sameCmt == 4) return forthPrize;
        if (sameCmt == 3) return fifthPrize;
        return 0;
    }

    public void RankCalculate(int sameCmt, int bonusCorrect, WinningHistory winningHistory) {
        if (sameCmt == 6) winningHistory.addFirstWinningCmt();
        if (sameCmt == 5 && bonusCorrect == 1) winningHistory.addSecondWinningCmt();
        if (sameCmt == 5) winningHistory.addThirdWinningCmt();
        if (sameCmt == 4) winningHistory.addForthWinningCmt();
        if (sameCmt == 3) winningHistory.addFifthWinningCmt();
    }

    public double rateCalculate(double purchasedAmount, double earning) {
        double earningRatio = ((earning - purchasedAmount) / purchasedAmount + 1) * 100;
        return Math.round(earningRatio * 10) / 10.0;
    }

}
