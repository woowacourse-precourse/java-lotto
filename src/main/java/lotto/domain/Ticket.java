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
        multipleOfTicketPriceCheck(money);
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

    private void multipleOfTicketPriceCheck(int money) {
        if (money % LottoConstants.TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return count;
    }
}
