package lotto.model;

import lotto.constants.ErrorMessage;

public class Money{

    private int money;
    public Money(String input) {
        validateNumber(input);
        this.money = money;
    }

    private void validateNumber(String input) {
        try {
            money = Integer.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }
}
