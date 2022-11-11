package lotto.util;

import static lotto.constant.SystemMessage.PURCHASE_COST_TYPE_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_UNIT_ERROR;

import lotto.view.Output;

public class InputValidator {

    public static boolean checkPurchaseCost(String purchaseCost) {
        return isTypeValid(purchaseCost) && isUnitValid(purchaseCost);
    }

    public static boolean isTypeValid(String purchaseCost) {
        boolean isType = purchaseCost.chars().allMatch(Character::isDigit);
        if (!isType) {
            Output.printError(PURCHASE_COST_TYPE_ERROR);
        }
        return isType;
    }

    public static boolean isUnitValid(String purchaseCost) {
        boolean isUnit = Integer.parseInt(purchaseCost) % 1000 == 0;
        if (!isUnit) {
            Output.printError(PURCHASE_COST_UNIT_ERROR);
        }
        return isUnit;
    }
}
