package lotto.view;

import lotto.service.EarningRateService;

import java.text.DecimalFormat;

public class EarningRateView {

    EarningRateService service = new EarningRateService();
    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void print() {

        double earningRate = service.calculate();

        System.out.println("총 수익률은 " + formatter.format(earningRate) + "%입니다.");
    }
}
