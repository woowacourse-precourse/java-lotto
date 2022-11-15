package lotto.service;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoCalculation;
import lotto.model.LottoMachine;
import lotto.model.StatisticsResult;

public class LottoService {
    private LottoMachine lottoMachine;
    private LottoCalculation lottoCalculation;

    public List<Lotto> publishLottoTickets(int purchaseAmount) {
        lottoMachine = new LottoMachine(purchaseAmount);
        return lottoMachine.getLottoTickets();
    }

    public int getLottoTicketCount() {
        return lottoMachine.getLottoTicketCount();
    }

    public void createWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumber);
        Bonus bonus = new Bonus(bonusNumber);
        lottoCalculation = new LottoCalculation(winningLotto, bonus);
    }

    public StatisticsResult computeWinningResult() {
        for (Lotto userLotto : lottoMachine.getLottoTickets()) {
            lottoCalculation.computeWinningResult(userLotto);
        }
        return lottoCalculation.getStatisticsResult();
    }

    public double computeRateOfReturn() {
        return lottoCalculation.computeRateOfReturn(lottoMachine.getPurchaseAmount());
    }
}