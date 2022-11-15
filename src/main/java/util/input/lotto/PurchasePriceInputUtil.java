package util.input.lotto;

import camp.nextstep.edu.missionutils.Console;
import validation.Validator;

public class PurchasePriceInputUtil {
    public static int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");

        String purchasePrice = Console.readLine().trim();

        validate(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    private static void validate(String purchasePrice) {
        Validator validator = new Validator();

        validator.validatePurchasePrice(purchasePrice);
    }
}
