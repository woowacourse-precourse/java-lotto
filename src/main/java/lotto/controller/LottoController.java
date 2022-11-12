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
        lottoData = new LottoData(inputLotto.money);
        outputView.printPurchaseAmount(lottoData.lottoAmount);
        lottoData.makeLotto();
        outputView.printPurchaseLottoNumbers(lottoData.allLotto);
    }

    public void checkLottoResult() {
        inputView.printInputWinNumbers();
        inputLotto.inputWinNumber();
        inputView.printInputBonusNumber();
        inputLotto.inputBonusNumber(inputLotto.winNumbers);
        lottoData.putDataToLotto(inputLotto.winNumbers, inputLotto.bonusNumber);
        outputView.printPrize(lottoData.prize);
        outputView.printPercentageOfReturn(lottoData.percentageOfReturn());
    }
}