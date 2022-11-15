package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoSystem {
    private final LottoMaker lottoMaker;
    private final WinningAnalyzer winningAnalyzer;

    public LottoSystem(){
        this.lottoMaker = new LottoMaker();
        this.winningAnalyzer = new WinningAnalyzer();
    }

    public void run() {
        int inputMoney = InputView.getInputMoney();
        int ticketCount = lottoMaker.calculateTicketCount(inputMoney);
        List<Lotto> lottos = lottoMaker.makeLottoTickets(ticketCount);
        OutputView.printLottoTicktesCount(ticketCount);
        OutputView.printLottoTikects(lottos);

        WinningLotto winningLotto = new WinningLotto(InputView.getInputAnswer(), InputView.getInputBonusNumber());
        winningAnalyzer.compareAllLottos(winningLotto, lottos);
        Map<Rank, Integer> result = winningAnalyzer.getResult();
        OutputView.printWinningStatistics(result);
        OutputView.printRate(winningAnalyzer.calculateRate(result,inputMoney));

    }
}
