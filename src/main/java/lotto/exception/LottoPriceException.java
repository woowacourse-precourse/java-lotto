package lotto.exception;

public class LottoPriceException {

    private static final String DIGIT_REGEX = "[0-9]+";
    private static final int LOTTO_PRICE = 1000;
    private static final String NO_DIGIT_ERROR_MESSAGE = "[ERROR] 로또 금액을 숫자로 입력해주세요.";
    private static final String LOW_PRICE_ERROR_MESSAGE = "[ERROR] 로또 1장은 1000원입니다. 1000원 보다 더 높은 금액을 입력해주세요.";
    private static final String WRONG_PRICE_ERROR_MESSAGE = "[ERROR] 로또 1장은 1000원입니다. 1000단위의 금액을 입력해주세요.";

    public static void checkLottoPrice(String priceInput) {
        CommonInputException.checkCommonInput(priceInput);
        Integer price = changePriceToInteger(priceInput);
        checkLessThanOneThousand(price);
        checkThousandUnits(price);
    }

    public static Integer changePriceToInteger(String price) {
        if (!price.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(NO_DIGIT_ERROR_MESSAGE);
        }
        return Integer.parseInt(price);
    }

    public static void checkLessThanOneThousand(Integer price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOW_PRICE_ERROR_MESSAGE);
        }
    }

    public static void checkThousandUnits(Integer price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(WRONG_PRICE_ERROR_MESSAGE);
        }
    }
}
