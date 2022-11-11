package lotto.view;

import lotto.model.ProfitRate;

public class ProfitRateView {
    public static void outPut(ProfitRate profitRate) {
        double rate = profitRate.getRate();
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}