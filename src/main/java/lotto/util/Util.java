package lotto.util;

import lotto.system.Constant;

import java.text.DecimalFormat;

public final class Util {
    private Util() {}

    public static float calculateYield(float after, float before) {
        return (after / before) * 100 - 100;
    }

    public static String formatFloat(float target, int precision)  {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String roundedYield = String.format("%." + precision + "f", target);
        return formatter.format(Float.parseFloat(roundedYield));
    }
}

