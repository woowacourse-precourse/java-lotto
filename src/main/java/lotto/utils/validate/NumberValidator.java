package lotto.utils.validate;

import static lotto.utils.message.ErrorMessagesUtil.*;
import static lotto.utils.message.NumberMessageUtil.LOTTO_COUNT;
import static lotto.utils.message.NumberMessageUtil.LOTTO_MAX;
import static lotto.utils.message.NumberMessageUtil.LOTTO_MIN;
import static lotto.utils.message.NumberMessageUtil.LOTTO_PRICE;

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

        if (Integer.parseInt(money) % LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE.getMessage());
        }
    }

    public static void validateNumber(String number) {
        validateCommon(number);

        validateNumber(Integer.parseInt(number));
    }

    public static void validateNumber(int number) {
        if (number < LOTTO_MIN.getNumber()) {
            throw new IllegalArgumentException(LOWER_NUMBER.getMessage());
        }

        if (number > LOTTO_MAX.getNumber()) {
            throw new IllegalArgumentException(UPPER_NUMBER.getMessage());
        }
    }

    public static void validateNumbersSize(List<?> numbers) {
        if (numbers.size() != LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers, String number) {
        validateCommon(number);

        if (numbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

}
