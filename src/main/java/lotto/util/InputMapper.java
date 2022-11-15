package lotto.util;

import lotto.config.InputConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputMapper {
    private static final String ERROR_MESSAGE = InputConfig.ERROR_MESSAGE;
    private static final String ERROR_INVALID_SPLIT_REGEX = ERROR_MESSAGE + " (%s)로 구분된 입력을 해주세요.";
    private static final String SPLIT_REGEX = ",";


    public List<Integer> splitByComma(String input) {
        try {
            return Arrays.stream(input.split(SPLIT_REGEX)).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_INVALID_SPLIT_REGEX, SPLIT_REGEX));
        }
    }
}
