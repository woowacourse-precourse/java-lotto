package lotto;

import java.util.List;

public class Controller {
    public void run() {
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
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
}
