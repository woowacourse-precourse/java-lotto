package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

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
        int inputAmount = inputView.getInputAmount();
        RandomLotto randomLotto = lottoService.makeRandomLottoNumbers(new Money(inputAmount));
        resultView.showNumberOfLottoPurchase(randomLotto);
        resultView.showAllRandomLottoNumbers(randomLotto);

        Lotto lotto = new Lotto(inputView.getWinningNums(), inputView.getBonusNum());

    }
}
