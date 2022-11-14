package lotto.controller;

import java.util.ArrayList;
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
        int lottoQuantity = getLottoQuantity();
        List<Lotto> lottos = getLottos(lottoQuantity);
        WinningLotto winningLotto = makeWinningLotto();
        makeResult(lottos, winningLotto);
    }

    private void makeResult(List<Lotto> lottos, WinningLotto winningLotto) {
        StatisticsMaker statisticsMaker = new StatisticsMaker();

        Map<Integer, Integer> ranking = statisticsMaker.makeRankings(winningLotto, lottos);
        double yield = statisticsMaker.makeYield(lottos, ranking);

        Statistics statistics = new Statistics(ranking, yield);
        OutputView.printWinningStatistics(statistics);
    }

    private List<Lotto> getLottos(int lottoQuantity) {
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(lottoMachine.generateLottoNumber()));
        }
        OutputView.printInputMoneyResultMessage(lottoQuantity);
        OutputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private int getLottoQuantity() {
        Clerk clerk = new Clerk();

        OutputView.printMoneyInputMessage();

        return clerk.giveLottoQuantity(InputView.inputMoney());
    }

    private WinningLotto makeWinningLotto() {
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();

        OutputView.printWinningNumbersInputMessage();
        List<Integer> winningLottoNumber = winningLottoMachine.giveWinningLottoNumber(InputView.inputWinningNumber());

        OutputView.printBonusNumberInputMessage();
        int winningLottoBonusNumber = winningLottoMachine.giveWinningLottoBonusNumber(InputView.inputBonusNumber());

        return new WinningLotto(winningLottoNumber, winningLottoBonusNumber);
    }

}
