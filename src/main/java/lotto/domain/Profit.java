package lotto.domain;

import java.util.List;

public class Profit {

    public Profit() {
    }


    public double calProfitRate(List<Integer> winningPrices, int place) {
        int winningAmount = calWinningAmount(winningPrices);
        int purchaseAmount = calPurchaseAmount(winningPrices.size());
        double profitRate = (double) winningAmount / (double) purchaseAmount * 100;

        return roundPlace(profitRate, place);
    }

    private double roundPlace(double d, int place) {
        double pow = Math.pow(10, place - 1);
        return Math.round(d * pow) / pow;
    }

    private int calPurchaseAmount(int size) {
        return BuyLotto.LOTTO_PRICE * size;
    }

    private int calWinningAmount(List<Integer> winningPrices) {
        return winningPrices
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
