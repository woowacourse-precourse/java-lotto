package lotto.domain.controller;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.view.LottoGuide;

public class LottoGame {
    private LottoGuide lottoGuide;

    public LottoGame() {
        lottoGuide = new LottoGuide();
    }

    public void playLottoGame() {
        int purchaseAmount = lottoGuide.getPurchaseAmount();

        List<Lotto> lottos = LottoIssuer.issueLottos(purchaseAmount);

        lottoGuide.informIssuedLottos(lottos);
    }
}
