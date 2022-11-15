package lotto.controller;

import lotto.domain.LottoMarket;
import lotto.domain.LottoResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.Wallet;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.OutputView.*;

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

        print(INPUT_MESSAGE_FOR_MONEY);
        LottoTickets lottoTickets = lottoMarket.buy(createWallet());

        displayCount(lottoTickets);
        displayLottoTickets(lottoTickets.getLottoTickets());

        return lottoTickets;
    }

    private Wallet createWallet() {
        return new Wallet(inputView.readInt());
    }

    private void displayCount(LottoTickets lottoTickets) {
        int count = lottoTickets.getCount();

        outputView.printCountOfLottoTickets(count);
    }

    private void displayLottoTickets(List<Lotto> lottoTickets) {
        outputView.printAllLottoTickets(lottoTickets);
    }

    private void displayResult(LottoResult lottoResult) {
    }

}
