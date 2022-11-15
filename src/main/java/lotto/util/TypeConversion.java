package lotto.util;

import static lotto.constant.ErrorType.NUMBER_TYPE_ERROR;
import static lotto.constant.TypeConversionConstant.SPLIT_EXPRESSION;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConversion {

    public static int stringToInt(String input) {

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR.getMessage());
        }

        return number;
    }

    public static List<String> splitInputByComma(String input) {
        String[] splitInput = input.split(SPLIT_EXPRESSION.getValue());

        return Arrays.asList(splitInput);
    }

    public static List<Integer> stringToIntList(String input) {

        List<String> playerNumbers = splitInputByComma(input);

        return playerNumbers.stream()
                .map(TypeConversion::stringToInt)
                .collect(Collectors.toList());
    }
}
