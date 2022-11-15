package lotto.caculation;

import lotto.utils.MoneyFalseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {
    private static final Pattern CORRECT_MONEY_PATTERN = Pattern.compile("^[0-9]*$");

    private int money;

    public Money(String input) {
        checkPattern(input);
        money = Integer.parseInt(input);
        if (money % 1000 != 0 && money >= 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다.");
        }
    }

    private void checkPattern(String input) {
        Matcher matcher = CORRECT_MONEY_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(MoneyFalseException.catchException());
        }
    }

    public int divideMoney(int referenceValue) {
        return money / referenceValue;
    }

    public double getMoney(){
        return money;
    }
}
