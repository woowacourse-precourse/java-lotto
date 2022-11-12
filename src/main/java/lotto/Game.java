package lotto;

import lotto.domain.Buyer;
import lotto.domain.Presenter;

import java.util.List;

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
        inputWinLottoNumberMessage();
        List<Integer> winLottoNumber = Presenter.inputWinLottoNumber();
    }
}
