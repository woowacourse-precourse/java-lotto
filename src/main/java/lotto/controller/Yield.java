package lotto.controller;

import lotto.view.OutputView;

public class Yield {
    double yield;

    public Yield(int userPrice, Compare userCompare) {
        int totalRevenue = SumWinLotto(userCompare.fifth, userCompare.fourth, userCompare.third, userCompare.second, userCompare.first);
        yield = YieldLotto(totalRevenue, userPrice);
        OutputView.OutputYield(yield);
    }

    public int SumWinLotto(int fifth, int fourth, int third, int second, int first) {
        int totalRevenue = (fifth*5000) + (fourth*50000) + (third*1500000) + (second*30000000) + (first*2000000000);
        return totalRevenue;
    }

    private double YieldLotto(int totalRevenue, int userPrice) {
        return Math.round((totalRevenue / (double) userPrice * 100) * 10) / 10.0;
    }
}
