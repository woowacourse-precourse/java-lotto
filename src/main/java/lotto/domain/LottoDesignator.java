package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoDesignator {
    private static final String INT_REGEX = "^[0-9]*$";

    public void checkOnlyNumber(String input) {
        String lotto = Arrays
                .stream(removeComma(input))
                .collect(Collectors.joining());
        if(!lotto.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
        }
    }

    private String[] removeComma(String input) {
        return input.split(",");
    }
}
