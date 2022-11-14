package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;

    public LottoController(InputView inputView, OutputView outputView, LottoFactory lottoFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
    }

    public void run() {
        Money money = insertMoney();
        LottoTicket lottoTicket = purchaseLottoTicket(money);
        WinningNumbers winningNumbers = chooseWinningNumbers();
        Result result = new Result(lottoTicket.checkLottoTicketWinningCountByRank(winningNumbers));
        announceWinningResult(money, result);
    }

    private Money insertMoney() {
        outputView.printRequestMoney();
        return new Money(inputView.requestMoney());
    }

    private LottoTicket purchaseLottoTicket(Money money) {
        LottoTicket lottoTicket = new LottoTicket(lottoFactory.purchaseLottoTicket(money));
        outputView.printLottoNumberOfTicket(lottoTicket.lottoTicket());
        return lottoTicket;
    }

    private WinningNumbers chooseWinningNumbers() {
        outputView.printRequestWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(inputView.requestWinningNumbers());

        outputView.printRequestBonusNumber();
        winningNumbers.chooseBonusNumber(inputView.requestBonusNumber());

        return winningNumbers;
    }

    private void announceWinningResult(Money money, Result result) {
        outputView.printResultStatistic(result.result());
        outputView.printRateOfProfit(result.prizeStatistic(money));
    }
}
