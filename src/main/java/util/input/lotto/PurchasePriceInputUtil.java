package util.input.lotto;

import static util.input.global.InputUtil.getInput;

import camp.nextstep.edu.missionutils.Console;
import validation.Validator;

public class PurchasePriceInputUtil {
    public static int getPurchasePrice() {
        printMessage();

        String purchasePrice = getInput();

        validate(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    private static void printMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private static void validate(String purchasePrice) {
        Validator validator = new Validator();

        validator.validatePurchasePrice(purchasePrice);
    }
}
