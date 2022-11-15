package lotto.utils;

import java.text.DecimalFormat;

public class Formatter {

    public static String format(int money) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(money);
    }
}
