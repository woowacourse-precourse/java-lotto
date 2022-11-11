package lotto.domain;

import static lotto.constant.SystemMessage.PURCHASE_COST_TYPE_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_UNIT_ERROR;

public class Cost {
    private final int cost;

    public Cost(String cost) {
        validate(cost);
        this.cost = Integer.parseInt(cost);
    }

    private void validate(String cost) {
        checkTypeValid(cost);
        checkUnitValid(cost);
    }

    public int getCost() {
        return cost;
    }

    public static void checkTypeValid(String purchaseCost) {
        boolean isType = purchaseCost.chars().allMatch(Character::isDigit);
        if (!isType) {
            throw new IllegalArgumentException(PURCHASE_COST_TYPE_ERROR);
        }
    }

    public static void checkUnitValid(String purchaseCost) {
        boolean isUnit = Integer.parseInt(purchaseCost) % 1000 == 0;
        if (!isUnit) {
            throw new IllegalArgumentException(PURCHASE_COST_UNIT_ERROR);
        }
    }

}
