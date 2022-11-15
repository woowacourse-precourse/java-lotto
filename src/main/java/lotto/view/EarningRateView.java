package lotto.view;

import lotto.domain.Constants;
import lotto.service.EarningRateService;

import java.text.DecimalFormat;

public class EarningRateView {

    EarningRateService service = new EarningRateService();
    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void print() {

        double earningRate = service.calculate();

        System.out.println(Constants.TOTAL_EARNING_IS + formatter.format(earningRate) + Constants.PERCENT_NOTICE);
    }
}
