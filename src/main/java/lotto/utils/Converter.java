package lotto.utils;

import static lotto.utils.Constants.LOTTO_PRICE;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> convertToIntegerList(String input) {
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int convertToCountsOfLotto(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }

    public static String convertToStringWithComma(int money) {
        DecimalFormat commaFormatter = new DecimalFormat("###,###");
        return commaFormatter.format(money);
    }

    public static String convertToStringWithCommaAndDot(double rate) {
        int integralPart = (int) rate;
        double decimalPart = rate - integralPart;
        long roundDecimalPart = Math.round(decimalPart * 10);

        return convertToStringWithComma(integralPart) + '.' + roundDecimalPart;
    }
}
