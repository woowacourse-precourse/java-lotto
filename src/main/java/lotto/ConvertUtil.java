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

    private String IntegerPartOfNumber(String number) {
        return number.chars()
                .limit(number.indexOf('.'))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String DecimalPartOfNumber(String number) {
        return number.chars()
                .skip(number.indexOf('.'))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
