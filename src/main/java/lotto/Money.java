package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Money {
    private final Integer money;

    public Money() {
        String money = getMoney();
        validate(money);
        this.money = stringToInt(money);
    }

    private String getMoney() {
        return Console.readLine();
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
}
