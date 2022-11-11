package lotto.model;

import static lotto.constant.MoneyConstants.*;

public class Money {
    private int money;

    public static Money of(String userInput){
        return new Money(userInput);
    }

    private Money(String userInput){
        validate(userInput);

        this.money = Integer.parseInt(userInput);
    }

    public int calculateCount() {
        return this.money / LOTTO_PRICE;
    }

    private void validate(String userInput){
        isBlank(userInput);
        isConsistsWithOnlyDigits(userInput);
        isDividedClearlyByLottoPrice(userInput);
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

    private void isDividedClearlyByLottoPrice(String userInput) {
        if (Integer.parseInt(userInput) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(REMAINDER_IN_MONEY_MSG);
        }
    }


}
