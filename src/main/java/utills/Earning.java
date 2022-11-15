package utills;

import winning.WinningHistory;

import java.util.List;

public class Earning {

    private static final double firstPrize = 2_000_000_000;
    private static final double secondPrize = 30_000_000;
    private static final double thirdPrize = 1_500_000;
    private static final double forthPrize = 50_000;
    private static final double fifthPrize = 5000;

    private WinningHistory winningHistory = new WinningHistory();
    private int sameCmt;
    private int bonusCorrect;

    public void scoreCalculate(List<Integer> purchasedLotto, List<Integer> winningLotto, int bonusNumber) {
        initializedValues();
        sameCmt = comparePurchasedWithWinningLotto(purchasedLotto, winningLotto);
        if (sameCmt == 5 && purchasedLotto.contains(bonusNumber)) {
            bonusCorrect++;
        }

        rankCalculate();
    }

    private void initializedValues() {
        sameCmt = 0;
        bonusCorrect = 0;
    }

    private int comparePurchasedWithWinningLotto(List<Integer> purchasedLotto, List<Integer> winningLotto) {
        for (Integer purchasedLottoNumber : purchasedLotto) {
            if (winningLotto.contains(purchasedLottoNumber)) {
                sameCmt++;
            }
        }
        return sameCmt;
    }

    public double priceCalculate() {
        if (sameCmt == 6) return firstPrize;
        if (sameCmt == 5 && bonusCorrect == 1) return secondPrize;
        if (sameCmt == 5) return thirdPrize;
        if (sameCmt == 4) return forthPrize;
        if (sameCmt == 3) return fifthPrize;
        return 0;
    }

    public void rankCalculate() {
        if (sameCmt == 6) winningHistory.addFirstWinningCount();
        if (sameCmt == 5 && bonusCorrect == 1) winningHistory.addSecondWinningCount();
        if (sameCmt == 5) winningHistory.addThirdWinningCount();
        if (sameCmt == 4) winningHistory.addForthWinningCount();
        if (sameCmt == 3) winningHistory.addFifthWinningCount();
    }

    public double rateCalculate(double purchasedAmount, double earning) {
        double earningRatio = ((earning - purchasedAmount) / purchasedAmount + 1) * 100;
        return Math.round(earningRatio * 10) / 10.0;
    }

    public WinningHistory getWinningHistory() {
        return winningHistory;
    }
}
