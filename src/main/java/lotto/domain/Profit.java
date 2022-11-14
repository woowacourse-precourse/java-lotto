package lotto.domain;

import java.util.List;

public class Profit {

    public Profit() {
    }
    public double calProfitRate(List<Integer> winningPrices, int lottoPrice, int place) {
        double winningAmount = winningPrices.stream().mapToInt(Integer::intValue).sum();
        double purchaseAmount = (lottoPrice * winningPrices.size());
        double profitRate = winningAmount / purchaseAmount * 100;

        return roundPlace(profitRate, place);
    }

    private double roundPlace(double d, int place) {
        double pow = Math.pow(10, place - 1);
        return Math.round(d * pow) / pow;
    }
}
