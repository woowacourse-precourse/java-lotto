package lotto;

import lotto.GenerateLotto;

import java.util.Arrays;
import java.util.List;

public class ControlLottoGame {
    private int quantity;

    ControlLottoGame() {
    }

    public void priceToQuantity(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_PRICE.get());
        }
        this.quantity = input / 1000;
    }

}
