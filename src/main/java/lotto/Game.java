package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        int amount = buyer.buyLotto(Console.readLine());
        Stats.compare(buyer.getLottos(), inputWinLottoNumber(), inputBonusNumber());
        Stats.calculateProfit(amount);
    }
}
