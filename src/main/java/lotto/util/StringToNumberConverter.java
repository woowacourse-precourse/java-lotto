package lotto.util;

public class StringToNumberConverter implements Converter<String, Integer> {

    private static final String ERROR_MESSAGE = "[ERROR] 숫자로 변환할 수 없습니다. 입력: %s\n";

    @Override
    public Integer convert(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            System.out.printf(ERROR_MESSAGE, target);
            throw new IllegalArgumentException(e);
        }
    }

}
