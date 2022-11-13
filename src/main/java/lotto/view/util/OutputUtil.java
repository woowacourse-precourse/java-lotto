package lotto.view.util;

import java.text.NumberFormat;
import java.util.Locale;

public class OutputUtil {
    public static String IntegerToStringWithComma(Integer integer) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(integer);
    }
}
