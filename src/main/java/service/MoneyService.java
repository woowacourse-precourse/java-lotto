package service;

import java.util.regex.Pattern;

public class MoneyService {
    public void savePurchaseAmount(String amount) {

    }

    private void validatePurchaseAmount(String amount) {
        checkAmountFormat(amount);
    }

    private void checkAmountFormat(String amount) {
        Format format = Format.PURCHASE_AMOUNT;

        if (Pattern.matches(format.getRegex(), amount)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_FORMAT.getText());
        }
    }

}
