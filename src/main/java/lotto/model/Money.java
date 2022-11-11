package lotto.model;

import static lotto.constant.MoneyConstants.*;

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
        isConsistsWithOnlyDigits(userInput);
    }

    private void isBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(EMPTY_MONEY_MSG);
        }
    }

    private void isConsistsWithOnlyDigits(String userInput) {
        for (char piece : userInput.toCharArray()) {
            isDigit(piece);
        }
    }

    private void isDigit(char piece) {
        if (!Character.isDigit(piece)) {
            throw new IllegalArgumentException(CHARACTER_IN_MONEY_MSG);
        }
    }


}
