package lotto.domain;

import lotto.constants.LottoConstants;

public class Ticket {
    private int count;

    Ticket(String userInput) {
        validate(userInput);
        count = Integer.parseInt(userInput) / LottoConstants.TICKET_PRICE.getValue();
    }

    private void validate(String userInput) {
        int money = numberFormatCheck(userInput);
    }

    private int numberFormatCheck(String userInput) {
        int value;
        try {
            value = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public int getCount() {
        return count;
    }
}
