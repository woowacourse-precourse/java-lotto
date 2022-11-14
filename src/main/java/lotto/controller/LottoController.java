package lotto.controller;

import lotto.domain.RateOfReturn;
import lotto.domain.Ticket;
import lotto.domain.Win;
import lotto.dto.BonusNumberDto;
import lotto.dto.MoneyDto;
import lotto.dto.WinningNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    // TODO 분리
    public void process() {
        try {
            MoneyDto moneyDto = InputView.inputMoney();
            int money = moneyDto.getMoney();

            // 로또 구매 >> Ticket.purchase();
            Ticket tickets = Ticket.purchase(money);
            int count = tickets.size();
            String lottoNumbers = tickets.getPurchaseContext();
            OutputView.printPurchaseLottoMessage(count, lottoNumbers);

            WinningNumbersDto winningNumbersDto = InputView.inputWinningNumbers();

            BonusNumberDto bonusNumberDto = InputView.inputBonusNumber(winningNumbersDto);

            // 당첨 통계 계산
            Win win = Win.compare(tickets, winningNumbersDto.getWinningNumbers(), bonusNumberDto.getBonusNumber());
            double winnings = win.getWinnings();
            List<Integer> winningsCount = win.getWinningsCount();
            OutputView.printWinnings(winningsCount);
            RateOfReturn rateOfReturn = new RateOfReturn(winnings, money);
            OutputView.printRateOfReturn(rateOfReturn.calculate());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return;
        }
    }
}
