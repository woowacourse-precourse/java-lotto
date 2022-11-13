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
        buyer.buyLottos(buyer.inputLottoAmount());
        List<Integer> winLottoNumber = Presenter.inputWinLottoNumber();
        int bonusNumber = Presenter.inputBonusNumber();
    }
}
