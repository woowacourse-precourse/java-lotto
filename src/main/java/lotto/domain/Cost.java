package lotto.domain;

import static lotto.constant.SystemMessage.PURCHASE_COST_TYPE_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_UNIT_ERROR;

import lotto.view.Output;

public class Cost {
    private final int cost;

    public Cost(String cost) {
        validate(cost);
        this.cost = Integer.parseInt(cost);
    }

    private void validate(String cost) {
        if (!isTypeValid(cost) || !isUnitValid(cost)) {
            throw new IllegalArgumentException();
        }
    }

    public int getCost() {
        return cost;
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
