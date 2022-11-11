package lotto.util;

import lotto.service.OutputService;

public class StringToNumberConverter implements Converter<String, Integer> {

    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없습니다. 입력: ";

    @Override
    public Integer convert(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            OutputService.printErrorMessage(ERROR_MESSAGE + target);
            throw new IllegalArgumentException(e);
        }
    }

}
