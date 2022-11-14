package controller;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoRank;
import lotto.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        getResult(lottos, winningLotto);
    }

    private List<Lotto> getLottos() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoGame.getLottos(lottoCount);

        OutputView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto getWinningLotto() {
        String winningLottoNumber = InputView.getWinningLottoNumbers();
        String winningBonusNumber = InputView.getWinningBonusNumber(winningLottoNumber);

        return LottoGame.createWinningLotto(winningLottoNumber, winningBonusNumber);
    }

    private void getResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = LottoGame.getLottoResult(lottos, winningLotto);
    }
}
