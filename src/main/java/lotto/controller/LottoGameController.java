package lotto.controller;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.InputMessage;

public class LottoGameController {
    private final InputMessage inputMessage = new InputMessage();

    public void lottoGameStart() {
        LottoGame lottoGame = new LottoGame();
        inputMessage.gameStart();
        int amount = inputMessage.purchaseAmountMessage(lottoGame.getUserAmount());
        inputMessage.purchasedLottoNumberMessage(lottoGame.getLottos(amount/1000));
        List<Integer> winningNumber = inputMessage.winningNumberMessage(lottoGame.getWinningNumber());
        int bonusNumber = inputMessage.bonusNumberMessage(lottoGame.getBonusNumber());
    }
}
