package lotto.util;

import static lotto.exception.ExceptionMessages.InvalidNumberMessage;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    private NumberParser() {
    }

    public static int stringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InvalidNumberMessage.getMessage());
        }
    }

    public static List<Integer> stringArrayToIntegerList(String[] array) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
            numbers.add(stringToInteger(s));
        }
        return numbers;
    }

    public static String doubleToString(double number) {
        String format = String.format("%.2f", number);
        return truncateDecimalPointIfZero(format);
    }

    private static String truncateDecimalPointIfZero(String format) {
        if (format.charAt(format.length() - 1) == '0') {
            format = format.substring(0, format.length() - 1);
        }
        if (format.charAt(format.length() - 1) == '0') {
            format = format.substring(0, format.length() - 2);
        }
        return format;
    }
}