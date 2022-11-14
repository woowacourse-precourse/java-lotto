package lotto.utils.validate;

import static lotto.utils.message.ErrorMessagesUtil.*;

import java.util.List;
import java.util.regex.Pattern;

public class NumberValidator {

    /**
     * 공통 검증 로직입니다.
     */
    private static void validateCommon(String number) {
        if (Pattern.matches(".*\\s.*", number)) { // 공백을 입력하면 예외 발생
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }

        if (Pattern.matches(".*\\D.*", number)) { // 문자가 섞이면 예외 발생
            throw new IllegalArgumentException(ONLY_NUMBERS.getMessage());
        }
    }

    public static void validateBuyMoney(String money) {
        validateCommon(money);

        if (Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException(LOWER_MONEY.getMessage());
        }

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE.getMessage());
        }
    }

    public static void validateInputNumber(String input) {
        validateCommon(input);

        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(LOWER_NUMBER.getMessage());
        }

        if (Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException(UPPER_NUMBER.getMessage());
        }
    }

    public static void validateNumbersSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_MATCH_NUMBERS_SIZE.getMessage());
        }
    }

}
