package lotto;

import static lotto.config.Constants.LottoPrice.LOTTO_PRICE;

public class LottoPublisher {

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }
    }

    private int affordableLotto(int money) {
        return money / LOTTO_PRICE;
    }
}
