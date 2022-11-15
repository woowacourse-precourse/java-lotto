package lotto.controller;

import lotto.domain.LottoMarket;
import lotto.domain.LottoTickets;
import lotto.domain.Wallet;

import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoTickets lottoTickets = buyLottoTickets();
    }

    private LottoTickets buyLottoTickets() {
        LottoMarket lottoMarket = new LottoMarket();

        return lottoMarket.buy(createWallet());
    }

    private Wallet createWallet() {
        return new Wallet(inputView.readInt());
    }



}
