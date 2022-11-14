package lotto.logic;

public class LottoAmount {
    public static final Integer LOTTO_PRICE = 1000;

    public static Long getLottoAmount(Long money) {
        checkInputUnit(money);

        Long amount = money / LOTTO_PRICE;

        return amount;
    }

    private static void checkInputUnit(Long input) {
        if (input % LOTTO_PRICE > 0) {
            String message = String.format("로또 구매 금액은 %d단위로 작성해야 합니다.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }
    }
}
