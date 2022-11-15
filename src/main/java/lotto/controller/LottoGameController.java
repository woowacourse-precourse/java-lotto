package lotto.controller;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.WinningResult;
import lotto.view.InputMessage;
import lotto.view.ResultMessage;

public class LottoGameController {
    private final InputMessage inputMessage = new InputMessage();
    private final ResultMessage resultMessage = new ResultMessage();

    public void lottoGameStart() {
        //로또 게임 진행
        LottoGame lottoGame = new LottoGame();
        inputMessage.gameStart();
        int amount = inputMessage.purchaseAmountMessage(lottoGame.getUserAmount());
        List<List<Integer>> lottos = inputMessage.purchasedLottoNumberMessage(lottoGame.getLottos(amount));
        List<Integer> winningNumber = inputMessage.winningNumberMessage(lottoGame.getWinningNumber());
        int bonusNumber = inputMessage.bonusNumberMessage(lottoGame.getBonusNumber());
        //결과 산정
        WinningResult winningResult = new WinningResult(lottos);
        LinkedHashMap<LottoRank, Integer> result = winningResult.getStatistics(winningNumber, bonusNumber);
        resultMessage.winningStatisticsPrint();
        resultMessage.winningResultMessage(result);
        resultMessage.yieldMessage(winningResult.revenueCalculation(amount));
    }
}
