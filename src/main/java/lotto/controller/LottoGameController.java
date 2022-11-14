package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputMessage;

public class LottoGameController {
    private final InputMessage inputMessage = new InputMessage();

    public void lottoGameStart() {
        LottoGame lottoGame = new LottoGame();
        inputMessage.gameStart();
        inputMessage.purchaseAmountMessage(lottoGame.GetUserInput());
    }
}
