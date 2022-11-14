package lotto.util;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    private final static String COMMA = ",";
    private final static String ONLY_NUMBER_REGEX = "^\\d+$";

    public static Integer toPurchasePrice(String arg) {
        Integer purchasePrice = toNumericValue(arg);
        validateIfInThousands(purchasePrice);
        return purchasePrice;
    }

    public static Integer toNumericValue(String arg) {
        validateIfNumeric(arg);
        Integer numericValue = Integer.valueOf(arg);
        return numericValue;
    }

    public static List<Integer> separate(String arg) {
        String[] argSplitted = arg.split(COMMA);
        validateFormat(argSplitted);

        List<Integer> numbers = new ArrayList<>();
        for (String element : argSplitted) {
            numbers.add(toNumericValue(element));
        }
        return numbers;
    }

    private static void validateIfNumeric(String arg) {
        boolean isNumber = arg.matches(ONLY_NUMBER_REGEX);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    private static void validateIfInThousands(Integer number) {
        if (number % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }

    private static void validateFormat(String[] args) {
        if (args.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NO_COMMAS_FOUND);
        }
    }
}
