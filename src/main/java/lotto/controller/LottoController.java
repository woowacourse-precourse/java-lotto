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
        try {
            int purchaseAmount = InputView.getPurchaseAmount();
            LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());
            printLottosInformation(lottoGenerator, lottos);
            WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumber(), InputView.getLottoBonusNumber());
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);
            printWinningInformation(winningDetails, purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottosInformation(LottoGenerator lottoGenerator, Lottos lottos) {
        OutputView.printHowManyLottoUserPurchased(lottoGenerator.getLottoQuantity());
        OutputView.printLottos(lottos);
    }

    private void printWinningInformation(Map<WinningRank, Integer> winningDetails, int purchaseAmount) {
        OutputView.printWinningStatistics();
        OutputView.printWinningDetails(winningDetails);
        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        OutputView.printLottoYield(WinningStatistics.getLottoYield(winningAmount, purchaseAmount));
    }
}
