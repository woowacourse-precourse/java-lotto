package lotto;

import java.util.List;

public class Controller {
    public void run() {
        getLottoInfo();
    }

    private void getLottoInfo() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoGame.getLottos(lottoCount);
    }
}
