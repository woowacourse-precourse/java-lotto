package lotto.controller;

import lotto.domain.*;
import lotto.domain.enums.LottoResult;
import lotto.view.OutputView;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void run() {
        Money money = new Money(inputMoney());
        WinningLotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber(), winningLotto);
        LottoGame lottoGame = new LottoGame(money, winningLotto, bonusNumber);

        LottoQuantity lottoQuantity = getLottoQuantity(lottoGame);
        Lottos lottos = getLottos(lottoQuantity, lottoGame);
        LottoResults lottoResults = getLottoResults(lottos, lottoGame);
        getRateOfReturn(lottoResults, lottoGame);
    }

    private WinningLotto getWinningLotto() {
        String winningNumbers = inputWinningNumbers();
        return new WinningLotto(winningNumbers);
    }

    private LottoQuantity getLottoQuantity(LottoGame lottoGame) {
        LottoQuantity lottoQuantity = lottoGame.generateQuantity();
        printLottoQuantity(lottoQuantity);
        return lottoQuantity;
    }

    private Lottos getLottos(LottoQuantity lottoQuantity, LottoGame lottoGame) {
        Lottos lottos = lottoGame.generateLottos(lottoQuantity);
        printLottoNumbers(lottos);
        return lottos;
    }

    private LottoResults getLottoResults(Lottos lottos, LottoGame lottoGame) {
        LottoResults lottoResults = lottoGame.generateLottoResult(lottos);
        printLottoResult(lottoResults);
        return lottoResults;
    }

    private void getRateOfReturn(LottoResults lottoResults, LottoGame lottoGame) {
        RateOfReturn rateOfReturn = lottoGame.generateRateOfReturn(lottoResults);
        printRateOfReturn(rateOfReturn);
    }
}
