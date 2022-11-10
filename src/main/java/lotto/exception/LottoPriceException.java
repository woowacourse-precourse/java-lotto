package lotto.exception;

public class LottoPriceException {

    public static void checkLottoPrice(String priceInput) {
        checkEmptyLottoPrice(priceInput);
        checkHasBlankInLottoPrice(priceInput);
    }

    public static void checkEmptyLottoPrice(String price) {
        if (price.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 금액을 입력해주세요.");
        }
    }

    public static void checkHasBlankInLottoPrice(String price) {
        if (!price.equals(price.trim())) {
            throw new IllegalArgumentException("[ERROR] 로또 금액을 공백없이 입력해주세요.");
        }
    }
}
