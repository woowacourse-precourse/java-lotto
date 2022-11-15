package lotto.validate;

import static lotto.log.CustomLogger.*;

public class Validator {

    public static void validNumber(String str) {
        long count = str.chars()
                .filter(i -> !Character.isDigit(i))
                .count();
        if (count != 0) {
            LOG.severe("숫자 입력이 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
}
