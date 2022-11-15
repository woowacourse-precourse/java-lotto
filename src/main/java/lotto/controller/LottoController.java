package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.StatisticsResult;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView;
    private final LottoInputView lottoInputView;
    private LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        lottoService = new LottoService();
    }

    public void run() {
        publishUserLotto();
        assignWinningLotto();
        calculateWinningStatistics();
    }

    private void publishUserLotto() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.publishLottoTickets(purchaseAmount);
        lottoOutputView.printLottoTicketCount(lottoService.getLottoTicketCount());
        lottoOutputView.printLottoTickets(lottoTickets);
    }

    private int inputPurchaseAmount() {
        lottoOutputView.printInputPurchaseAmount();
        return lottoInputView.inputPurchaseAmount();
    }

    private void assignWinningLotto() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        lottoService.createWinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> inputWinningNumber() {
        lottoOutputView.printInputWinningNumber();
        return lottoInputView.inputWinningNumber();
    }

    private int inputBonusNumber() {
        lottoOutputView.printInputBonusNumber();
        return lottoInputView.inputBonusNumber();
    }

    private void calculateWinningStatistics() {
        StatisticsResult statistics = lottoService.computeWinningResult();
        lottoOutputView.printStatistics(statistics);
        double rateOfReturn = lottoService.computeRateOfReturn();
        lottoOutputView.printRateOfReturn(rateOfReturn);
    }
}
