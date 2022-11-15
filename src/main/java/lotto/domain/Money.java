package lotto.domain;

import lotto.domain.message.ErrorMessages;

import java.util.NoSuchElementException;

public class Money {
    private long money;

    public Money(String input) {
        this.money = validate(input);
    }

    private long validate(String input) {
        long money;
        if (!isNumeric(input)) {
            System.out.println(ErrorMessages.MONEY_NOT_INTEGER.get());
            throw new NoSuchElementException(ErrorMessages.MONEY_NOT_INTEGER.get());
        }
        money = Long.parseLong(input);
        if (money < 1000) {
            System.out.println(ErrorMessages.MONEY_UNDER_1000.get());
            throw new IllegalArgumentException();
        }
        if (money % 1000 != 0) {
            System.out.println(ErrorMessages.MONEY_NOT_DIVIDED_BY_1000.get());
            throw new IllegalArgumentException();
        }
        return money;
    }
    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public long getLottoCount() {
        return this.money / 1000;
    }

    public long getMoney() {
        return this.money;
    }
}
