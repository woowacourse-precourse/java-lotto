package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void process() {
        Lottos purchaseTickets = purchaseLottos();
        LottoResults lottoResults = createResultFrom(purchaseTickets);
        outputView.printLottoResult(lottoResults);
    }

    private LottoResults createResultFrom(Lottos purchaseTickets) {
        LottoWinNumber lottoWinNumber = inputView.inputWinNumber();
        Map<LottoWin, Integer> lottoWinResults = purchaseTickets.lottoResults(lottoWinNumber);
        return new LottoResults(lottoWinResults);
    }

    private Lottos purchaseLottos() {
        Cash cash = inputView.inputCash();
        LottoMachine lottoMachine = new LottoMachine(cash);
        Lottos purchaseTickets = lottoMachine.purchaseLottos();
        outputView.printPurchaseTicketCounts(purchaseTickets.getLottos().size());
        outputView.printLottoNumber(purchaseTickets);
        return purchaseTickets;
    }
}
