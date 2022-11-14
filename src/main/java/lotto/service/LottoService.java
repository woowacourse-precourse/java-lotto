package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.util.constants.WinningScore;

public class LottoService {
    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

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

    public Map<WinningScore, Integer> computeWinningResult() {
        lottoResult = new LottoResult(winningLotto.getBonusNumber());
        for (Lotto userLotto : lottoMachine.getLottoTickets()) {
            lottoResult.computeWinningScore(userLotto, winningLotto.getWinningLotto());
        }
        return lottoResult.getWinningScoreResult();
    }

    public double computeRateOfReturn() {
        return lottoResult.computeRateOfReturn(lottoMachine.getPurchaseAmount());
    }
}