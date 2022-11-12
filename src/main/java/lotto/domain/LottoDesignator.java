package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoDesignator {
    private static final String INT_REGEX = "^[0-9]*$";
    private static final int CIPHER = 6;

    public void checkOnlyNumber(String input) {
        String lotto = Arrays
                .stream(removeComma(input))
                .collect(Collectors.joining());
        if(!lotto.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
        }
    }

    public void checkSixCipher(String input) {
        String[] lotto = removeComma(input);
        if(lotto.length != CIPHER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    private String[] removeComma(String input) {
        return input.split(",");
    }
}
