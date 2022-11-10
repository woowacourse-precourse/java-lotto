package lotto.util.input;

import java.util.regex.Pattern;

public class Money {
    private int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
    private void validate(String money) {
        validateOnlyNumber(money);
        validateRemainder(money);
    }
    private void validateOnlyNumber (String money) {
        String REGEX = "^[0-9]+$";
        if (!Pattern.matches(REGEX, money)) {
            throw new IllegalArgumentException("REGEX ERROR");
        }
    }
    private void validateRemainder (String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("REMAINDER ERROR");
        }
    }
}
