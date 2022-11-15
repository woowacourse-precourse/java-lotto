package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ProfitRateView {
    public static void outPut(BigDecimal profitRate) {
        DecimalFormat format = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + format.format(profitRate) + "%입니다.");
    }
}