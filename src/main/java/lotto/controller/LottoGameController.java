package lotto.controller;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.InputMessage;

public class LottoGameController {
    private final InputMessage inputMessage = new InputMessage();

    public void lottoGameStart() {
        LottoGame lottoGame = new LottoGame();
        inputMessage.gameStart();
        int amount = lottoGame.getUserAmount();
        int count = amount / 1000;
        inputMessage.purchaseAmountMessage(amount);
        List<List<Integer>> lotts = lottoGame.getLottos(count);
        inputMessage.purchasedLottoNumberMessage(lotts);
        List<Integer> winningNumber = lottoGame.getWinningNumber();
        inputMessage.winningNumberMessage(winningNumber);
        Integer bonusNumber = lottoGame.getBonusNumber();
        inputMessage.bonusNumberMessage(bonusNumber);
    }
}
