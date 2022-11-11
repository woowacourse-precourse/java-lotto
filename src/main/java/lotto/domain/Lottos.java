package lotto.domain;

import lotto.exception.LottoPriceException;
import lotto.view.InputView;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private Integer quantity;

    public Lottos() {
        this.quantity = countLottoQuantityByInputPrice();
    }

    public Integer countLottoQuantityByInputPrice() {
        String price = InputView.lottoPriceInput();
        LottoPriceException.checkLottoPrice(price);
        return Integer.parseInt(price) / LOTTO_PRICE;
    }
}
