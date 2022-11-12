package lotto;

import lotto.domain.Wallet;
import lotto.utils.Constant;
import lotto.views.Input;

public class GameManager {

    private final Input input;
    private Wallet wallet;

    public GameManager(Input input) {
        this.input = input;
    }

    public void run() {
        int lottoPrice = input.getUserMoney();
        int numberOfPurchase = changeNumberOfLottoToBuy(lottoPrice);
    }

    public int changeNumberOfLottoToBuy(int lottoPrice) {
        return lottoPrice % Constant.LOTTO_PRICE;
    }
}
