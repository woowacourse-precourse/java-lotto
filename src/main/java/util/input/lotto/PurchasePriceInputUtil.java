package util.input.lotto;

import static lotto.Message.INPUT_PURCHASE_PRICE;
import static util.input.global.InputUtil.getInput;

import validation.Validator;

public class PurchasePriceInputUtil {
    public static int getPurchasePrice() {
        printMessage();

        String purchasePrice = getInput();

        validate(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    private static void printMessage() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
    }

    private static void validate(String purchasePrice) {
        Validator validator = new Validator();

        validator.validatePurchasePrice(purchasePrice);
    }
}
