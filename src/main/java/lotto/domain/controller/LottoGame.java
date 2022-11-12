package lotto.domain.controller;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.view.LottoGuide;

public class LottoGame {
    private LottoGuide lottoGuide;
    private LottoIssuer lottoIssuer;

    public LottoGame() {
        lottoGuide = new LottoGuide();
        lottoIssuer = new LottoIssuer();
    }

    public void playLottoGame() {
        int purchaseAmount = lottoGuide.getPurchaseAmount();

        int numberOfLottos = purchaseAmount / 1000;

        List<Lotto> lottos = lottoIssuer.issueLottos(numberOfLottos);

        lottoGuide.informIssuedLottos(lottos);
    }
}
