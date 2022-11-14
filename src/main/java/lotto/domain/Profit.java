package lotto.domain;

import java.util.List;

public class Profit {

    public Profit() {
    }

    private int calProfit(int winningPrice, int lottoPrice) {
        return winningPrice - lottoPrice;
    }

    public double calProfitRate(List<Integer> winningPrices, int lottoPrice) {
        return sumProfit(winningPrices, lottoPrice) / (lottoPrice * winningPrices.size())  * 100;
    }

    private int sumProfit(List<Integer> winningPrices, int lottoPrice) {
        int sum = 0;
        for (Integer winningPrice : winningPrices) {
            sum = sum + calProfit(winningPrice, lottoPrice);
        }

        return sum;
    }
}
