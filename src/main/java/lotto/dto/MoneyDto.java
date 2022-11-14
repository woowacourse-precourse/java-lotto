package lotto.dto;

import lotto.util.StringUtils;

import java.util.regex.Pattern;

public class MoneyDto {
    private static final String MONEY_PATTERN = "^[0-9]*0{3}$"; // 1000배수
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "금액은 0보다 큰 1000원 단위로만 입력할 수 있습니다.";
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";

    private int money;

    public MoneyDto(String money) {
        this(parseMoney(money));
    }

    public MoneyDto(int money) {
        this.money = money;
    }

    private static int parseMoney(final String money) {
        validate(money);
        return Integer.parseInt(money);
    }

    private static void validate(final String money) {
        validateBlank(money);
        validateNumberFormat(money);
    }

    private static void validateNumberFormat(final String money) {
        if (!Pattern.matches(MONEY_PATTERN, money)) {
            throw new IllegalArgumentException(NUMBER_FORM_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBlank(final String money) {
        if (StringUtils.isBlank(money)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }
}
