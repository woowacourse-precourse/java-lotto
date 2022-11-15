package lotto.view.outputView;

import java.text.DecimalFormat;

public class YieldOutputView {
    public static void showYield(double yield) {
        DecimalFormat df = new DecimalFormat();
        StringBuffer yieldInfo = new StringBuffer();
        yieldInfo.append("총 수익률은 ")
                .append(df.format(yield))
                .append("%입니다.");
        System.out.println(yieldInfo);
    }
}
