package lotto.controller;

import lotto.domain.LottoMarket;
import lotto.domain.LottoResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.Wallet;

import lotto.domain.winning.WinningNumbers;
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
        Wallet wallet = createWallet();
        LottoTickets lottoTickets = buyLottoTickets(wallet);

        WinningNumbers winningNumbers = createWinningNumbers();
        LottoResult lottoResult = createLottoResult(lottoTickets, winningNumbers);
        displayResult(lottoResult, wallet);
    }

    private LottoTickets buyLottoTickets(Wallet wallet) {
        LottoMarket lottoMarket = new LottoMarket();

        print(INPUT_MESSAGE_FOR_MONEY);
        LottoTickets lottoTickets = lottoMarket.buy(wallet);

        displayCount(lottoTickets);
        displayLottoTickets(lottoTickets.getLottoTickets());

        return lottoTickets;
    }

    private Wallet createWallet() {
        return new Wallet(inputView.readInt());
    }

    private WinningNumbers createWinningNumbers() {
        print(INPUT_MESSAGE_FOR_WINNING_NUMBERS);
        List<Integer> winningNumbers = inputView.readWinningNumbers();

        print(INPUT_MESSAGE_FOR_BONUS_NUMBER);
        int bonusNumber = inputView.readInt();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private LottoResult createLottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        outputView.printLottoResultMessage();

        LottoResult lottoResult = lottoTickets.makeResult(winningNumbers);

        return lottoResult;
    }

    private void displayCount(LottoTickets lottoTickets) {
        int count = lottoTickets.getCount();

        outputView.printCountOfLottoTickets(count);
    }

    private void displayLottoTickets(List<Lotto> lottoTickets) {
        outputView.printAllLottoTickets(lottoTickets);
    }

    private void displayResult(LottoResult lottoResult, Wallet wallet) {
        outputView.printLottoResultMessage();
        outputView.printResult(lottoResult.getResult(), lottoResult.calculateYield(wallet));
    }

}
