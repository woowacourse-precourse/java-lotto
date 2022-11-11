package lotto.model;

import static lotto.constant.MoneyConstants.*;

import lotto.constant.MoneyConstants;

public class Money {
    private int money;

    public static Money valueOf(String userInput){
        return new Money(userInput);
    }

    private Money(String userInput){
        validate(userInput);

        this.money = Integer.parseInt(userInput);
    }

    private void validate(String userInput){
        isBlank(userInput);
    }

    private void isBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(EMPTY_MONEY_MSG);
        }
    }


}
