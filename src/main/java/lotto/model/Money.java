package lotto.model;

import lotto.model.exception.InputException;

import lotto.view.ErrorMessages;

public class Money {

    private static final int MONETARY_UNIT = 1000;
    private static final int TICKET_PRICE = 1000;
    private static final int REMAINDER = 0;
    private final long money;

    public Money(String input) {
        String trimmedInput = input.trim();

        validateInput(trimmedInput);

        this.money = Long.parseLong(trimmedInput);
    }

    private void validateInput(String input) {
        try {
            validateElement(input);
            validateMonetary(input);
        } catch (IllegalArgumentException e) {
            throw new InputException(e.getMessage());
        }
    }

    private void validateElement(String input) {

        long count = input.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .count();

        if (isValidMonetaryUnit(count, input.length())) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_ELEMENT.getErrorMessage());
        }
    }

    private void validateMonetary(String input) {
        if (isValidMonetaryUnit(Long.parseLong(input) % MONETARY_UNIT, REMAINDER)) {
            throw new IllegalArgumentException(ErrorMessages.MONETARY_UNIT.getErrorMessage());
        }
    }

    private boolean isValidMonetaryUnit(long inputNumber, int remainder) {
        return inputNumber != remainder;
    }

    public long getMoney() {
        return this.money;
    }

    public long getNumberOfTickets() {
        return this.money / TICKET_PRICE;
    }
}
