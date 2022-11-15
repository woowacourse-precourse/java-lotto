package lotto.domain;

import java.util.NoSuchElementException;

public class Money {
    private int money2;

    public Money(String money) {
        validate(money);
    }

    private void validate(String money) {
        if (!isNumeric(money)) {
            System.out.println(Message.NUMBER_CONTAINS_ALPABET.get());
            throw new NoSuchElementException(Message.NUMBER_CONTAINS_ALPABET.get());
        }
        money2 = Integer.parseInt(money);

        if (money2 < 1000) {
            System.out.println(Message.MONEY_IS_LOWER_THAN_1000.get());
            throw new IllegalArgumentException();
        }
        if (money2 % 1000 != 0) {
            System.out.println(Message.MONEY_CANT_DIVIED_BY_1000.get());
            throw new IllegalArgumentException();
        }
    }
    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public long getMoney() {
        return money2;
    }

}
