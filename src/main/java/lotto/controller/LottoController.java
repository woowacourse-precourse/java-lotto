package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = buyLottos(lottoMachine);
        WinningLotto winningLotto = generateWinningLotto();
        LottoResult lottoResult = lottos.checkResult(winningLotto);

        int totalPurchasedPrice = lottoMachine.calculatePurchasingPrice(lottos);
        double yield = lottoResult.calculateYield(totalPurchasedPrice);
        OutputView.printResult(lottoResult, yield);
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningLottos = inputView.inputWinningNumbers();
        int bonusBallNumber = inputView.inputBonusBallNumber();
        return WinningLotto.of(winningLottos, bonusBallNumber);
    }

    private Lottos buyLottos(LottoMachine lottoMachine) {
        PurchasingPrice purchasingPrice = new PurchasingPrice(inputView.inputPurchasingPrice());
        Lottos lottos = lottoMachine.issueLottos(purchasingPrice);
        OutputView.printAllLottoNumbers(lottos);
        return lottos;
    }

}
