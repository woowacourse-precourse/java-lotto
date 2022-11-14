package lotto.utils;

import static lotto.resources.ValidationPattern.PATTERN;

public class StringToIntConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String target) {
        if (PATTERN.canConvert(target)) {
            return Integer.parseInt(target);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주시기 바랍니다.");
    }
}
