package lotto.controller;

import lotto.model.InputLotto;
import lotto.model.LottoData;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputLotto inputLotto = new InputLotto();
    LottoData lottoData;

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
        lottoData.calculateAllData();
        outputView.printPrize(lottoData.prize.getPrize());
        outputView.printPercentageOfReturn(lottoData.percentageOfReturn);
    }
}