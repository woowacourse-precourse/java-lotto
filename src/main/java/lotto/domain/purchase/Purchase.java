package lotto.domain.purchase;

public class Purchase {
    private static final String NOT_INTEGER_ERROR = "[ERROR] 정수 값이 입력되어야 합니다.";
    private static final String PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    private final int purchaseAmount;

    public Purchase(String input) {
        validateInteger(input);

        int purchaseAmount = Integer.parseInt(input);
        validateMoneyUnit(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public int getAmount() {
        return purchaseAmount;
    }

    public int numOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private void validateInteger(String input) {
        String regex = "^[0-9]+$";

        if (!input.matches(regex)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }

    private void validateMoneyUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR);
        }
    }
}
