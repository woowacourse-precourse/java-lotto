package lotto.model;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PRICE = 100000;
    private static final String INPUT_PRICE_ERROR = "[ERROR] 잘못된 가격을 입력하셨습니다.";

    public int changeToLotto(int money) {
        validate(money);
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE || money > MAX_PRICE) {
            throw new IllegalArgumentException(INPUT_PRICE_ERROR);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_PRICE_ERROR);
        }
    }
}
