package lotto.controller;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.InputMessage;

public class LottoGameController {
    private final InputMessage inputMessage = new InputMessage();

    public void lottoGameStart() {
        LottoGame lottoGame = new LottoGame();
        inputMessage.gameStart();
        int amount = lottoGame.GetUserInput();
        int count = amount / 1000;
        inputMessage.purchaseAmountMessage(amount);
        List<List<Integer>> lotts = lottoGame.getLottos(count);
        inputMessage.PurchasedLottoNumberMessage(lotts);

    }
}
