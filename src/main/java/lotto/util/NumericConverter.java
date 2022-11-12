package lotto.util;

public class NumericConverter implements Converter<String, Integer> {

    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없습니다. 입력: ";

    @Override
    public Integer convert(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + target, e);
        }
    }

}
