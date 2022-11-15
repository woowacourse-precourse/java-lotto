package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Clerk;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Statistics;
import lotto.domain.StatisticsMaker;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        int lottoQuantity = makeLottoQuantity();
        List<Lotto> lottos = makeLottos(lottoQuantity);
        WinningLotto winningLotto = makeWinningLotto();
        makeStatistics(lottos, winningLotto);
    }

    private void makeStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        StatisticsMaker statisticsMaker = new StatisticsMaker();

        Map<Integer, Integer> ranking = statisticsMaker.makeRankings(winningLotto, lottos);
        double yield = statisticsMaker.makeYield(lottos, ranking);
        Statistics statistics = statisticsMaker.makeStatistics(ranking, yield);

        OutputView.printWinningStatistics(statistics);
    }

    private List<Lotto> makeLottos(int lottoQuantity) {
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = lottoMachine.generateLottos(lottoQuantity);

        OutputView.printInputMoneyResultMessage(lottoQuantity);
        OutputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private int makeLottoQuantity() {
        Clerk clerk = new Clerk();

        OutputView.printMoneyInputMessage();

        return clerk.calculateLottoQuantity(InputView.inputMoney());
    }

    private WinningLotto makeWinningLotto() {
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();

        OutputView.printWinningNumbersInputMessage();
        List<Integer> winningLottoNumber = winningLottoMachine.generateWinningLottoNumber(InputView.inputWinningNumber());

        OutputView.printBonusNumberInputMessage();
        int winningLottoBonusNumber = winningLottoMachine.generateWinningLottoBonusNumber(InputView.inputBonusNumber());

        return winningLottoMachine.generateWinningLotto(winningLottoNumber, winningLottoBonusNumber);
    }

}
