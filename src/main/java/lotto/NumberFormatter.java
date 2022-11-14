package lotto;


import static lotto.Constant.NUMBER_CONVENTIONS;

import java.text.DecimalFormat;

public class NumberFormatter {
    private static DecimalFormat decFormat = new DecimalFormat(NUMBER_CONVENTIONS);

    public static String format(Integer number) {
        return decFormat.format(number);
    }

    public static String format(Double number) {
        return decFormat.format(number);
    }

}
