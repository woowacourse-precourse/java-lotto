package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.OutputService;

public class StringToNumbersConverter implements Converter<String, List<Integer>> {

    private static final String REGEX = ",";
    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없는 값이 포함되어 있습니다. 입력: ";

    @Override
    public List<Integer> convert(String target) {
        return Arrays.stream(target.split(REGEX))
            .map(this::convertToNumber)
            .collect(Collectors.toList());
    }

    private Integer convertToNumber(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            OutputService.printErrorMessage(ERROR_MESSAGE + target);
            throw new IllegalArgumentException(e);
        }
    }

}
