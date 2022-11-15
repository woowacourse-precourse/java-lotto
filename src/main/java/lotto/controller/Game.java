package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCashier;
import lotto.view.InputView;
import java.util.List;

public class Game {
    public void startLottoGame() {
        int money = InputView.inputLottoAmount();
        LottoCashier lottoCashier = new LottoCashier();
        int count = lottoCashier.getLottoCount(money);
        List<Lotto> lottos = lottoCashier.createLottoList(count);
    }
}
