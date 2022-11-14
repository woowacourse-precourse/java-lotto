package controller;

import lotto.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        Lottos lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        getResult(lottos, winningLotto);
    }

    private Lottos getLottos() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        Lottos lottos = LottoGame.getLottos(lottoCount);

        OutputView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto getWinningLotto() {
        String winningLottoNumber = InputView.getWinningLottoNumbers();
        String winningBonusNumber = InputView.getWinningBonusNumber(winningLottoNumber);

        return LottoGame.createWinningLotto(winningLottoNumber, winningBonusNumber);
    }

    private void getResult(Lottos lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);

        int totalWinnings = lottoResult.getLottoTotalMoney();
        double yield = LottoGame.getYield(totalWinnings, lottos.getLottoPrice());
    }
}
