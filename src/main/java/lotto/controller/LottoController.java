package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoTicket;
import lotto.model.LuckyNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.requestBonusNumber;
import static lotto.view.InputView.requestUserAmount;

public class LottoController {
    public void start(){
        LottoCount amount = requestUserAmount();
        LottoTicket lottoTicket = buyTickets(amount);
        LuckyNumbers luckyNumbers = getInputLuckyNumbers();
    }

    private LottoCount requestUserAmount(){
        try{
            return new LottoCount(InputView.requestUserAmount());
        } catch (IllegalArgumentException e){
            OutputView.printException(e);
        }
        return null;
    }

    private LottoTicket buyTickets(LottoCount amount){
        long ticketCount = amount.calculateLottoCount();
        OutputView.printTicketCount(ticketCount);
        LottoTicket lottoTicket = new LottoTicket(ticketCount);
        OutputView.printLottoTickets(lottoTicket);
        return lottoTicket;
    }

    private LuckyNumbers getInputLuckyNumbers(){
        try{
            return new LuckyNumbers(new Lotto(InputView.requestWinNumbers()), requestBonusNumber());
        } catch(IllegalArgumentException e){
            OutputView.printException(e);
        }
        return null;
    }
}
