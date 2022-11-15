package lotto;

import static lotto.enums.PrintMsg.*;
import static lotto.enums.Constant.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertUtil {
    public int StringIntoInt(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_INPUT_VALUE_IS_NOT_NUMBER.getMessage());
        }
    }

    public List<Integer> StringIntoList(String input) {
        try {
            List<Integer> result = Stream.of(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_WINNING_NUMBER_INPUT_IS_INVALID_INPUT_TYPE.getMessage());
        }
    }

    public String plainNumberIntoCommaNumber(String number) {
        return IntegerPartOfNumber(number) + DecimalPartOfNumber(number);
    }

    private String IntegerPartOfNumber(String number) {
        String integerPartOfNumber = number.chars()
                .limit(number.indexOf('.'))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return addCommaToNumber(integerPartOfNumber);
    }

    private String addCommaToNumber(String number) {
        StringBuffer newNumber = new StringBuffer(number);

        int commaIndex = newNumber.length() % COMMA_SPACING.getValue();
        if (commaIndex == 0) {
            commaIndex += COMMA_SPACING.getValue();
        }

        while (commaIndex < newNumber.length()) {
            newNumber.insert(commaIndex, ",");
            commaIndex += COMMA_SPACING.getValue() + 1;
        }

        return newNumber.toString();
    }

    private String DecimalPartOfNumber(String number) {
        return number.chars()
                .skip(number.indexOf('.'))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
