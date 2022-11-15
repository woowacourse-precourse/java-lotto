package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void execute() {
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(inputView.getMoney());
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);


        resultView.printTotalCount(lottoMachine.ticketsCount());
        resultView.printLottoTickets(lottoMachine.ticketsToString());

        WinningNumbers winningNumbers = new WinningNumbers(inputView.getWinner(), inputView.getBonusNumber());
        LottoResult lottoResult = lottoMachine.confirm(winningNumbers);

        resultView.printWinnerStat(lottoResult.getRanks());
        resultView.printEarningRatio(lottoResult.earningRate());
    }

}