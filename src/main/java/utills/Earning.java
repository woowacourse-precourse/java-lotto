package utills;

import lotto.Lotto;
import winning.WinningHistory;

import java.util.List;

public class Earning {

    private static final double firstPrize = 2_000_000_000;
    private static final double secondPrize = 30_000_000;
    private static final double thirdPrize = 1_500_000;
    private static final double forthPrize = 50_000;
    private static final double fifthPrize = 5000;

    private WinningHistory winningHistory = new WinningHistory();
    private double earningAmount = 0;

    public void scoreCalculate(List<Integer> purchasedLotto, List<Integer> winningLotto, int bonusNumber) {
        int sameCount = calculateSameCount(purchasedLotto, winningLotto);
        boolean bonusCorrect = sameCount == 5 && purchasedLotto.contains(bonusNumber);

        earningAmount += priceCalculate(sameCount, bonusCorrect);
        rankCalculate(sameCount, bonusCorrect);
    }

    private int calculateSameCount(List<Integer> purchasedLotto, List<Integer> winningLotto) {
        int sameCount = 0;
        for (Integer purchasedLottoNumber : purchasedLotto) {
            if (winningLotto.contains(purchasedLottoNumber)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public double priceCalculate(int sameCount, boolean bonusCorrect) {
        if (sameCount == 6) return firstPrize;
        if (sameCount == 5 && bonusCorrect) return secondPrize;
        if (sameCount == 5) return thirdPrize;
        if (sameCount == 4) return forthPrize;
        if (sameCount == 3) return fifthPrize;
        return 0;
    }

    public void rankCalculate(int sameCount, boolean bonusCorrect) {
        if (sameCount == 6) winningHistory.addFirstWinningCount();
        if (sameCount == 5 && bonusCorrect) winningHistory.addSecondWinningCount();
        if (sameCount == 5) winningHistory.addThirdWinningCount();
        if (sameCount == 4) winningHistory.addForthWinningCount();
        if (sameCount == 3) winningHistory.addFifthWinningCount();
    }

    public double rateCalculate(double purchasedAmount) {
        double earningRatio = ((earningAmount - purchasedAmount) / purchasedAmount + 1) * 100;
        return Math.round(earningRatio * 10) / 10.0;
    }

    public WinningHistory getWinningHistory() {
        return winningHistory;
    }
}
