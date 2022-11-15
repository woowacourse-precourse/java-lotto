package utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private static final String REGEX = ",";

    public static int convertStringToInt(String textNumber) {
        return Integer.parseInt(textNumber);
    }

    public static List<Integer> separateNumberWithComma(String textNumbers) {
        return Arrays.stream(textNumbers.split(REGEX))
                .map(Util::convertStringToInt)
                .collect(Collectors.toList());
    }

    public static float getProfit(float nowMoney, float pastMoney) {
        return nowMoney / pastMoney;
    }

    public static String convertIntegerToMoneyFormat(int money) {
        DecimalFormat dc = new DecimalFormat("###,###,###,###");
        return dc.format(money);
    }

}
