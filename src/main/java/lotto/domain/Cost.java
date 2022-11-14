package lotto.domain;


public class Cost {

    private static final String PURCHASE_COST_TYPE_ERROR = "구매 금액에 문자가 포함될 수 없습니다";
    private static final String PURCHASE_COST_UNIT_ERROR = "구매 금액은 %d원 단위여야 합니다";
    private static final int PRICE_PER_LOTTO = 1000;
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

    public int getPurchaseCount() {
        return cost / PRICE_PER_LOTTO;
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
            throw new IllegalArgumentException(String.format(PURCHASE_COST_UNIT_ERROR, PRICE_PER_LOTTO));
        }
    }

}
