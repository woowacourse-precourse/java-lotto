package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Enum.ConstantNumber.*;
import static lotto.Enum.ConstantString.REGEX_ONLY_NUMBER;
import static lotto.Enum.Error.*;


public class ConsoleInput {

    public static void purchaseLotto() {
        String purchaseAmount = Console.readLine();

        validatePurchaseOnlyNumber(purchaseAmount);

        int purchaseAmountToInt = Integer.parseInt(purchaseAmount);

        validatePurchaseRange(purchaseAmountToInt);

        validatePurchaseThousandModular(purchaseAmountToInt);
    }

    public static void drawLotto() {

    }

    private static void validatePurchaseOnlyNumber(String purchaseAmount) {
        if(!purchaseAmount.matches(REGEX_ONLY_NUMBER.getValue())){
            throw new IllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }
    }

    private static void validatePurchaseRange(int purchaseAmount) {
        if (purchaseAmount == ZERO.getValue() || purchaseAmount > HUNDRED_THOUSAND.getValue()) {
            throw new IllegalArgumentException(PURCHASE_RANGE_ERROR.getMessage());
        }
    }

    private static void validatePurchaseThousandModular(int purchaseAmount) {
        if (purchaseAmount % THOUSAND.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(PURCHASE_THOUSAND_MODULAR_ERROR.getMessage());
        }
    }
}
