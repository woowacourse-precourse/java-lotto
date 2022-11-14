package utils;

import java.text.DecimalFormat;

public class DecimalFormatter {

    private static final DecimalFormat formatter = new DecimalFormat("###,###.#");

    public static String formatNumber(Double number) {
        return formatter.format(number);
    }
}
