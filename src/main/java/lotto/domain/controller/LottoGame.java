package lotto.domain.controller;

import java.util.List;
import java.util.Map;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;
import lotto.domain.view.LottoGuide;

public class LottoGame {

    private LottoGuide lottoGuide;
    private LottoAnalyst lottoAnalyst;

    public LottoGame() {
        lottoGuide = new LottoGuide();
        lottoAnalyst = new LottoAnalyst();
    }

    public void playLottoGame() {
        int purchaseAmount = lottoGuide.getPurchaseAmount();

        List<Lotto> lottos = LottoIssuer.issueLottos(purchaseAmount);

        lottoGuide.informIssuedLottos(lottos);

        List<Integer> winningNumbers = lottoGuide.getWinningNumbers();
        int bonusNumber = lottoGuide.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<RankingInformation, Integer> statistics = lottoAnalyst.makeWinningStatistics(lottos,
                winningLotto);

        double rateOfReturn = lottoAnalyst.calculateRateOfReturn();

        lottoGuide.informWinningStatistics(statistics);
        lottoGuide.informRateOfReturn(rateOfReturn);
    }
}
