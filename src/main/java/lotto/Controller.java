package lotto;

import java.util.List;

public class Controller {
    public void run() {
        List<Lotto> lottos = getLottos();
    }

    private List<Lotto> getLottos() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoGame.getLottos(lottoCount);

        OutputView.printLottos(lottos);

        return lottos;
    }
}
