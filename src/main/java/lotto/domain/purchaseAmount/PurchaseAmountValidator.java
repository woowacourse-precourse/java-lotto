package lotto.domain.purchaseAmount;

public class PurchaseAmountValidator {
    private static final String EMPTY_PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 금액이 입력되지 않았습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.";
    private static final String LESS_THAN_ONE_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000원 미만의 값입니다.";
    private static final String NOT_DIVIDED_BY_ONE_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000원 단위가 아닙니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    public static void validate(String number) {
        validateEmptyPurchaseAmount(number);

        validateOnlyNumber(number);

        validateLessThanOneThousand(number);

        validateNotDividedByOneThousand(number);
    }

    public static void validateEmptyPurchaseAmount(String number) {
        if (number.isEmpty() || number == null) {
            throw new IllegalArgumentException(EMPTY_PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumber(String number) {
        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateLessThanOneThousand(String number) {
        long money = Long.parseLong(number);

        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LESS_THAN_ONE_THOUSAND_ERROR_MESSAGE);
        }
    }

    public static void validateNotDividedByOneThousand(String number) {
        long money = Long.parseLong(number);

        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_ONE_THOUSAND_ERROR_MESSAGE);
        }
    }
}
