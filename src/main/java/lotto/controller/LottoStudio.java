package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStudio {
    private final Lottos lottos = new Lottos();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() {
        Price price = new Price();
        price.setPrice(InputView.getInputPrice());
        price.setTrial(price.getPrice());
        lottos.setLottos(price.getTrial());
        OutputView.viewLottos(lottos);
        WinningLotto winningLotto = InputView.getInputWinningLotto();
        getStatistics(lottos, winningLotto, price);
    }

    private void getStatistics(Lottos lottos, WinningLotto winningNumber, Price price) {
        Statistic winningStatistics = lottos.getWinningStatistics(winningNumber);
        OutputView.printStatistics(winningStatistics);
        OutputView.printProfitRate(winningStatistics, price);
    }
}
