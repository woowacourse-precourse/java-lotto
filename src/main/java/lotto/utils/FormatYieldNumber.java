package lotto.utils;

import java.text.DecimalFormat;

public class FormatYieldNumber {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");

    public static String get(double yield) {
        return decimalFormat.format(yield);
    }
}