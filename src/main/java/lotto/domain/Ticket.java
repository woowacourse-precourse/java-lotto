package lotto.domain;

import lotto.constants.LottoConstants;

public class Ticket {
    private int count;

    Ticket(String userInput) {
        validate(userInput);
        count = Integer.parseInt(userInput) / LottoConstants.TICKET_PRICE.getValue();
    }

    private void validate(String userInput) {
        int money = Validator.numberFormatCheck(userInput);
        Validator.multipleOfTicketPriceCheck(money);
    }

    public int getCount() {
        return count;
    }
}
