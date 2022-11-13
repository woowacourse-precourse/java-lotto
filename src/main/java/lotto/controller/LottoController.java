package lotto.controller;

import lotto.model.InputLotto;
import lotto.model.LottoData;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputLotto inputLotto = new InputLotto();
    private LottoData lottoData;

    public void buyLotto() {
        inputView.printHowMuch();
        inputLotto.inputMoney();
        lottoData = inputLotto.makeLottoData();
        outputView.printPurchaseAmount((int) lottoData.lottoAmount);
        lottoData.makeLotto();
        outputView.printPurchaseLottoNumbers(lottoData.allLotto);
    }

    public void checkLottoResult() {
        inputView.printInputWinNumbers();
        inputLotto.inputWinNumber(lottoData);
        inputView.printInputBonusNumber();
        inputLotto.inputBonusNumber(lottoData, lottoData.winNumbers);
        lottoData.calculateAllLotto();
        outputView.printPrize(lottoData.prizeCount.getPrizeCount());
        outputView.printPercentageOfReturn(lottoData.percentageOfReturn);
    }
}