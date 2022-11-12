package lotto.util;

public class TypeConversion {

    private static final String PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE = "[ERROR] 구입금액은 숫자여야 합니다.";

    public static int stringToInt(String input) {

        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE);
        }

        return purchaseAmount;
    }
}
