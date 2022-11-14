package lotto.domain.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;
import lotto.domain.view.LottoGuide;
import lotto.exception.LottoGameExceptionHandler;

public class LottoGame {

    private LottoGuide lottoGuide;
    private LottoAnalyst lottoAnalyst;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private Map<RankingInformation, Integer> statistics;

    public LottoGame() {
        lottoGuide = new LottoGuide();
        lottoAnalyst = new LottoAnalyst();
        lottos = new ArrayList<>();
    }

    public void playLottoGame() {
        try {
            issueLottosAndInform();

            setWinningLotto();

            makeStatistics();

            informStatisticsAndRateOfReturn();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void issueLottosAndInform() {
        int purchaseAmount = lottoGuide.getPurchaseAmount();
        LottoGameExceptionHandler.handleAmountNotThousandsException(purchaseAmount);

        lottos = LottoIssuer.issueLottos(purchaseAmount);

        lottoGuide.informIssuedLottos(lottos);
    }

    private void setWinningLotto() {
        List<Integer> winningNumbers = lottoGuide.getWinningNumbers();
        int bonusNumber = lottoGuide.getBonusNumber();

        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    private void makeStatistics() {
        statistics = lottoAnalyst.makeWinningStatistics(lottos, winningLotto);
    }

    private void informStatisticsAndRateOfReturn() {
        double rateOfReturn = lottoAnalyst.calculateRateOfReturn();

        lottoGuide.informWinningStatistics(statistics);
        lottoGuide.informRateOfReturn(rateOfReturn);
    }
}
