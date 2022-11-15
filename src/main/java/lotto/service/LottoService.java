package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCalculation;
import lotto.model.LottoMachine;
import lotto.model.StatisticsResult;
import lotto.model.WinningLotto;

public class LottoService {
    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;
    private LottoCalculation lottoCalculation;

    public List<Lotto> publishLottoTickets(int purchaseAmount) {
        lottoMachine = new LottoMachine(purchaseAmount);
        return lottoMachine.getLottoTickets();
    }

    public int getLottoTicketCount() {
        return lottoMachine.getLottoTicketCount();
    }

    public void createWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumber);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public StatisticsResult computeWinningResult() {
        lottoCalculation = new LottoCalculation(winningLotto);
        for (Lotto userLotto : lottoMachine.getLottoTickets()) {
            lottoCalculation.computeWinningScore(userLotto);
        }
        return lottoCalculation.getStatisticsResult();
    }

    public double computeRateOfReturn() {
        return lottoCalculation.computeRateOfReturn(lottoMachine.getPurchaseAmount());
    }
}