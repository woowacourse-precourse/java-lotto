package lotto;

public class NumberValidator {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자로 이루어진 금액을 입력해야 합니다.";
    private static final String INVALID_PURCHASE_PRICE_ERROR_MESSAGE = "[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다.";

    private static final String MATCHER = "[+-]?\\d*(\\.\\d+)?";

    public static void isValidPurchasePrice(String lottoPrice) {
        isNumber(lottoPrice);
        isValidPrice(lottoPrice);
    }

    private static void isNumber(String number) {
        if (!number.matches(MATCHER)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void isValidPrice(String lottoPrice) {
        if (Integer.parseInt(lottoPrice) % 1000 != 0) {
            throw  new IllegalArgumentException(INVALID_PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }
}
