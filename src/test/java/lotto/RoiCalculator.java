package lotto;

public class RoiCalculator {

    public double roi(int totalMoneyWasted, int totalMoneyGained) {
        return ((double) totalMoneyGained / totalMoneyWasted) * 100;
    }
}
