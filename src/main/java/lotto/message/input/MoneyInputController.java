package lotto.message.input;

import lotto.message.ErrorMessage;

public class MoneyInputController extends InputController {

    public String input() {
        printController.printPurchaseMoneyMessage();
        return readLine();
    }

    public void validate(Object input) {
        long price;

        try {
            price = Long.parseLong((String) input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_NUMBER_MESSAGE.getMessage());
        }

        if (price == 0 || price % LOTTO_PER_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONE_THOUSAND_UNIT_MONEY_MESSAGE.getMessage());
        }
    }
}
