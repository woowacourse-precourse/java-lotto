package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.LottoAnalyzer;
import lotto.service.LottoGameService;

public class LottoGameController {

    private final LottoGameService lottoGameService;

    public LottoGameController() {
        this.lottoGameService = new LottoGameService();
    }

    public int buyLottoTickets(final String purchaseAmount) {
        return lottoGameService.buyLottoTickets(purchaseAmount);
    }

    public List<Lotto> saveLottoTickets(final int lottoTicketCount) {
        return lottoGameService.saveLottoTickets(lottoTicketCount);
    }

    public Lotto pickWinningNumbers(final String winningNumbers) {
        return lottoGameService.pickWinningNumbers(winningNumbers);
    }

    public int pickBonusNumber(final String bonusNumber) {
        return lottoGameService.pickBonusNumber(bonusNumber);
    }

    public LottoAnalyzer lookUpLotto() {
        return lottoGameService.lookUpLotto();
    }

    public String calculateRate(LottoAnalyzer lottoAnalyzer) {
        return lottoGameService.calculateRate(lottoAnalyzer);
    }
}
