package lotto.util;

import java.text.DecimalFormat;

public class NumberFormator {

    private static final DecimalFormat decFormat = new DecimalFormat("###,###");

    public static String divideEvery3Digits(int number) {
        return decFormat.format(number);
    }

    public static String roundToTwoDecimalPlaces(float number) {
        return String.format("%.1f", number);
    }

}
