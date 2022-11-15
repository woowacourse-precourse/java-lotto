package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void gameStart() {
        try {
            int inputAmount = inputView.getInputAmount();
            RandomLotto randomLotto = lottoService.makeRandomLottoNumbers(new Money(inputAmount));

            resultView.showNumberOfLottoPurchase(randomLotto);
            resultView.showAllRandomLottoNumbers(randomLotto);

            Lotto lotto = new Lotto(inputView.getWinningNums(), inputView.getBonusNum());
            HashMap<Winning, Integer> winningResultMap = lottoService.confirmWinningResult(randomLotto, lotto);
            WinningResult winningResult = new WinningResult(winningResultMap);

            resultView.showWinningResult(winningResult);
            resultView.showLottoYield(winningResult, inputAmount);

        } catch (IllegalArgumentException exception) {
            resultView.createErrorMessage(exception);
        }
    }
}
