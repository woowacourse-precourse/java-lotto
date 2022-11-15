package lotto;

import java.util.regex.Pattern;

public class Money {
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = stringToInt(money);
    }

    private void validate(String money) {
        final String MONEY_PATTERN = "^[1-9][0-9]*0{3}$";
        final String EXCEPTION_MESSAGE = "[ERROR] 숫자가 잘못된 형식입니다.";

        boolean isMatch = Pattern.matches(MONEY_PATTERN, money);

        if (!isMatch) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private int stringToInt(String money) {
        return Integer.parseInt(money);
    }

    public int getMoney() {
        return this.money;
    }
}
