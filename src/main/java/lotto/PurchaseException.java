package lotto;

public class PurchaseException {

    private static int MIN_RANGE_MONEY = 0;
    private static int MAX_RANGE_MONEY = 9;
    private static int MIN_AMOUNT = 1000;

    public static void validatePurchaseAmount(String amount) {
        if (isNumberOnly(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ONLY_MESSAGE);
        }

        if (isDivide(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumberOnly(String amount) {
        for (char money : amount.toCharArray()) {
            if (!(MIN_RANGE_MONEY <= money - '0' && money - '0' <= MAX_RANGE_MONEY)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDivide(String amount) {
        if (Integer.parseInt(amount) % MIN_AMOUNT != 0) {
            return true;
        }
        return false;
    }
}
