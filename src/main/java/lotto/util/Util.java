package lotto.util;

import java.text.DecimalFormat;
import java.util.List;

public final class Util {
    private Util() {}

    public static float calculateYield(float after, float before) {
        return (after / before) * 100 - 100;
    }

    public static String makeFloatFormatted(float target, int precision)  {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", target);
        return formatter.format(Float.parseFloat(rounded));
    }

    public static String makeIntegerListToStringFormat(List<Integer> target) {
        String result = target.toString();
        result = result.substring(1, result.length() - 1);
        result = result.replaceAll(" ", "");
        return result;
    }
}

