package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleNumericConverter implements Converter<String, List<Integer>> {

    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없는 값이 포함되어 있습니다. 입력: %s";

    @Override
    public List<Integer> convert(String target) {
        return Arrays.stream(target.split(SEPARATOR))
            .map(this::convertToNumeric)
            .collect(Collectors.toList());
    }

    private Integer convertToNumeric(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, target), e);
        }
    }

}
