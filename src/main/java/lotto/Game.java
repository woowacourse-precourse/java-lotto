package lotto;

import lotto.domain.Buyer;
import lotto.domain.Stats;

import static lotto.domain.Presenter.*;
import static lotto.view.InputView.*;

public class Game {

    private final Buyer buyer;

    public Game() {
        buyer = new Buyer();
    }

    public void play() {
        inputLottoAmountMessage();
        buyer.buyLotto();
        Stats.compare(buyer.getLottos(), inputWinLottoNumber(), inputBonusNumber());
        Stats.calculateProfit();
    }
}
