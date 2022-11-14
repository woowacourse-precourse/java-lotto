package lotto.controller;

import static lotto.view.InputView.inputMoney;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.service.LottoDrawService;
import lotto.service.LottoIssueService;
import lotto.service.LottoWinningNumberService;
import lotto.view.OutputView;

public class LottoGameController {

    public static void start() {
        Money money = new Money(inputMoney());
        OutputView.printLottoAmount(money);
        LottoTicket lottoTicket = issueTicket(money.calculateLottoAmount());

        Lotto winningNumbers = LottoWinningNumberService.generateLottoWinningNumber();
        int bonusNumber = LottoWinningNumberService.generateBonusNumber();
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);

        LottoResult lottoResult = draw(lottoTicket, lottoWinningNumber);
        OutputView.printProfit(new Profit(money, lottoResult.getTotalPrize()));
    }

    private static LottoTicket issueTicket(int lottoAmount) {
        LottoTicket lottoTicket = LottoIssueService.createLottoTicket(lottoAmount);
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private static LottoResult draw(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        LottoResult lottoResult = new LottoResult(LottoDrawService.drawLotto(lottoTicket, lottoWinningNumber));
        OutputView.printLottoResult(lottoResult.getLottoResult());
        return lottoResult;
    }
}
