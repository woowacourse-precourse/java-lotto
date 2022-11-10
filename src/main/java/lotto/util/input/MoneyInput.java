package lotto.util.input;

import java.util.regex.Pattern;

public class MoneyInput {
    private int money;

    public MoneyInput(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
    private void validate(String money) {

    }
    private boolean validateOnlyNumber (String money) {
        String REGEX = "^[0-9]$";
        return Pattern.matches(money, REGEX);
    }
}
