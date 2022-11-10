package lotto.exception;

public class LottoPriceException {

    public static void checkLottoPrice(String priceInput) {
        checkEmptyLottoPrice(priceInput);
    }

    public static void checkEmptyLottoPrice(String price) {
        if (price.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 금액을 입력해주세요.");
        }
    }
}
