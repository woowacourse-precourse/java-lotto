package lotto.utils;

public class UserInputValidator {

    private static final int UNIT_OF_MONEY = 1000;
    private static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 구입 금액은 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY = "[ERROR] 구입 금액은 1000원 단위만 가능합니다.";

    public static void validatePurchaseAmount(String purchaseAmount) {
        isDigit(purchaseAmount);
        isValidUnitOfMoney(Integer.parseInt(purchaseAmount));
    }

    private static void isDigit(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidUnitOfMoney(int purchaseAmount) {
        if (purchaseAmount % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY);
        }
    }
}
