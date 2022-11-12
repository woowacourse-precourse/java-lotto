package lotto;

import static lotto.Constant.COMMA_EVERY_THREE_DIGIT_PATTERN;
import static lotto.Constant.SHOW_TWO_DIGIT_UNDER_POINT_PATTERN;

import java.text.DecimalFormat;

public class NumberFormatter {
    private static DecimalFormat decFormat = new DecimalFormat(
            COMMA_EVERY_THREE_DIGIT_PATTERN + SHOW_TWO_DIGIT_UNDER_POINT_PATTERN); // TODO 이게 맞나? 가독성 아무리 봐도 너무구린데

    public static String format(Integer number) {
        return decFormat.format(number);
    }

    public static String format(Double number) {
        return decFormat.format(number);
    }

}
