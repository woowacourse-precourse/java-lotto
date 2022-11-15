package lotto.Account;

public class Account {
    private static final String NOT_NUMERIC_WARNING_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final String UNDER_1000_WON_WARNING_MESSAGE = "[ERROR] 구매 금액은 1000원 이상이어야 합니다.";
    private static final String NOT_1000_WON_UNIT_WARNING_MESSAGE = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    private static final Integer STANDARD_AMOUNT = 1000;

    private Integer purchaseAmount;

    public Account(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        this.purchaseAmount = Integer.valueOf(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        Integer numericAmount;
        if (isNotNumeric(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_NUMERIC_WARNING_MESSAGE);
        }
        numericAmount = Integer.valueOf(purchaseAmount);
        if (isUnder1000Won(numericAmount)) {
            throw new IllegalArgumentException(UNDER_1000_WON_WARNING_MESSAGE);
        }
        if (isNot1000WonUnit(numericAmount)) {
            throw new IllegalArgumentException(NOT_1000_WON_UNIT_WARNING_MESSAGE);
        }
    }

    private boolean isNotNumeric(String purchaseAmount) {
        try {
            Double.parseDouble(purchaseAmount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isUnder1000Won(Integer purchaseAmount) {
        if (purchaseAmount < STANDARD_AMOUNT) {
            return true;
        }
        return false;
    }

    private boolean isNot1000WonUnit(Integer purchaseAmount) {
        if (purchaseAmount % STANDARD_AMOUNT != 0) {
            return true;
        }
        return false;
    }


    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
