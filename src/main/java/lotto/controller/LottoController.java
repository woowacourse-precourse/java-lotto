package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void startLotto() {
        int price = InputView.inputPrice();
        LottoPrice lottoPrice = new LottoPrice(price);
        int amount = lottoPrice.getAmount();

        LottoCreator lottoCreator = new LottoCreator(amount);
        List<Lotto> lottos = lottoCreator.getLottos();

        OutputView.printLottos(lottos, amount);

        List<Integer> winNumbers = InputView.inputWinNumbers();
        WinNumber winNumber = new WinNumber(winNumbers);
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.getResult(lottos, winNumber, bonusNumber);

        Map<Result, Integer> resultMap = lottoResult.getResultMap();
        OutputView.printResult(resultMap);

        double earning = lottoResult.getEarning(price);
        OutputView.printEarning(earning);
    }
}
