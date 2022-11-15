package lotto.Domain;

public class ProfitCalculator {
    MatchWinning matchWinning;
    PurchasingLotto purchasingLotto;

    public double calculateProfit() {
        double earningRate = matchWinning.getProfit() / purchasingLotto.getPurchase() * 100;

        return earningRate;
    }
}
