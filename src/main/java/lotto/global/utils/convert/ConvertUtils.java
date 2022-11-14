package lotto.global.utils.convert;

import lotto.global.message.ErrorMessage;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtils {

    private static final String COMMA = ",";

    public static Integer convertStringToInteger(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INPUT_NUMBER);
        }
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER);
        }
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(COMMA))
                    .map(ConvertUtils::convertStringToInteger)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS);
        }
    }
}
