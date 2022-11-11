package lotto.controller;

import java.util.Map;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void lottoStart() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        Lottos lottos = new Lottos(lottoGenerator.generateLottos());

        OutputView.printHowManyLottoUserPurchased(lottoGenerator.getLottoQuantity());
        OutputView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumber(), InputView.getLottoBonusNumber());

        Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);
        OutputView.printWinningStatistics();
        OutputView.printWinningDetails(winningDetails);
        OutputView.printLottoYield(WinningStatistics.getLottoYield(winningDetails, purchaseAmount));
    }
}
