package lotto;

import lotto.domain.Buyer;

import static lotto.view.InputView.*;

public class Game {

    private final Buyer buyer;

    public Game() {
        buyer = new Buyer();
    }

    public void play() {
        inputLottoAmountMessage();
        int amount = buyer.inputLottoAmount();
        buyer.buyLottos(amount);
    }
}
