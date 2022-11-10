package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    public static void purchaseLotto() {
        String purchaseAmount = Console.readLine();

        validatePurchaseInput(purchaseAmount);

    }

    public static void drawLotto() {

    }

    private static void validatePurchaseInput(String purchaseAmount) {
        final String REGEX_ONLY_NUMBER = "[0-9]+";
        final int ZERO = 0;
        final int HUNDRED_THOUSAND = 100000;
        final int THOUSAND = 1000;

        if(!purchaseAmount.matches(REGEX_ONLY_NUMBER)){
            throw new IllegalArgumentException(Error.PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }

        int purchaseAmountToInt = Integer.parseInt(purchaseAmount);

        if (purchaseAmountToInt == 0 || purchaseAmountToInt > HUNDRED_THOUSAND) {
            throw new IllegalArgumentException(Error.PURCHASE_RANGE_ERROR.getMessage());
        }

        if (purchaseAmountToInt % THOUSAND != ZERO) {
            throw new IllegalArgumentException(Error.PURCHASE_THOUSAND_ERROR.getMessage());
        }
    }
}
