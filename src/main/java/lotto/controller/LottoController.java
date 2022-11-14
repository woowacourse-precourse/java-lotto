package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start(){
        LottoMoney money = input();
        LottoTicket tickets = buyTickets(money);
        Lotto winningLottoNumbers = getWinningNumbers();
        LottoBonus bonus = getBonus(winningLottoNumbers);
        WinningResult result = getWinningResult(tickets, winningLottoNumbers, bonus);
        printLottoStatics(result, money);
    }

    private LottoMoney input(){
        return new LottoMoney(InputView.moneyAmount());
    }

    private LottoTicket buyTickets(LottoMoney amount){
        int tickets = amount.calculateLottoTicket();
        OutputView.printLottoTicket(tickets);

        return new LottoTicket(tickets);
    }

    private Lotto getWinningNumbers(){
        return new Lotto(InputView.lottoNumbers());
    }

    private LottoBonus getBonus(Lotto lotto){
        return new LottoBonus(lotto.getNumbers(), InputView.bonusNumber());
    }

    private WinningResult getWinningResult(LottoTicket tickets, Lotto winningLottoNumbers, LottoBonus bonus){
        return new WinningResult(tickets, winningLottoNumbers, bonus);
    }

    private void printLottoStatics(WinningResult result, LottoMoney money){
        float profit = result.profit(money.getMoney());
        OutputView.printWinLottoStatistics(profit, result);
    }
}
