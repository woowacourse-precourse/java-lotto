package service;

import java.util.regex.Pattern;

public class MoneyService {
    public void savePurchaseAmount(String amount) {
        validatePurchaseAmount(amount);
    }

    private void validatePurchaseAmount(String amount) {
        checkAmountFormat(amount);

        int amountValue = Integer.parseInt(amount);
        checkAmountValue(amountValue);
    }

    private void checkAmountFormat(String amount) {
        Format format = Format.PURCHASE_AMOUNT;

        if (Pattern.matches(format.getRegex(), amount)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_FORMAT.getText());
        }
    }

    private void checkAmountValue(int amountValue) {
        Rule lotto = Rule.PER_LOTTO;

        if (!(amountValue % lotto.getPrice() == 0)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALUE.getText());
        }
    }

}
