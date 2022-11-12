package lotto.model;

import lotto.view.Messages;

public class Money {
    private final long money;
    public Money(String input) {
        input = input.trim();
        validateInput(input);
        this.money = Long.parseLong(input);
    }

    private void validateInput(String input) {
        validateElement(input);
        validateMoney(input);
    }

    public void validateElement(String input) {
        long count = input.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .count();

        if (count != input.length()) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_ELEMENT.getErrorMessage());
        }
    }
    public void validateMoney(String input) {
        if (Long.parseLong(input) % 1000 != 0) {
            throw new IllegalArgumentException(Messages.ERROR_MONEY.getErrorMessage());
        }
    }

    public long getMoney() {
        return this.money;
    }

    public long getNumberOfTickets() {
        return this.money / 1000;
    }

}
