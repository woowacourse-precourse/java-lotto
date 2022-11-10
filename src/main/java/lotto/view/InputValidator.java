package lotto.view;

class InputValidator {
    private static final int VALID_LOTTO_PRICE = 1000;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "[ERROR] 올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 구입 금액은 " + VALID_LOTTO_PRICE + "원 단위여야 합니다.";

    private InputValidator() {
    }

    public static void validatePurchaseAmount(String purchaseAmount) {
        Integer amount = validateNumeric(purchaseAmount);
        validateRange(amount);
    }

    private static Integer validateNumeric(String purchaseAmount) {
        try {
            return Integer.valueOf(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateRange(Integer amount) {
        if (amount < VALID_LOTTO_PRICE || amount % VALID_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }
}
