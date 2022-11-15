package lotto.util;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    private static final String COMMA = ",";
    private static final String ONLY_NUMBER_REGEX = "^\\d+$";

    public static Integer toPurchasePrice(String input) {
        final Integer purchasePrice = toNumericValue(input);
        validateIfInThousands(purchasePrice);
        return purchasePrice;
    }

    public static Integer toNumericValue(String input) {
        validateIfNumeric(input);
        final Integer numericValue = Integer.valueOf(input);
        return numericValue;
    }

    public static List<Integer> separate(String input) {
        final String[] inputSplitted = input.split(COMMA);
        validateFormat(inputSplitted);

        final List<Integer> numbers = new ArrayList<>();
        for (String element : inputSplitted) {
            numbers.add(toNumericValue(element));
        }
        return numbers;
    }

    private static void validateIfNumeric(String input) {
        final boolean isNumber = input.matches(ONLY_NUMBER_REGEX);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    private static void validateIfInThousands(Integer number) {
        if (number % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }

    private static void validateFormat(String[] inputs) {
        if (inputs.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_PROPER_COMMA);
        }
    }
}
