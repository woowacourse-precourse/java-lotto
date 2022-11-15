package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.requestBonusNumber;
import static lotto.view.InputView.requestUserAmount;

public class LottoController {
    public void start(){
        LottoCount amount = requestUserAmount();
        LottoTicket lottoTicket = buyTickets(amount);
        LuckyNumbers luckyNumbers = getInputLuckyNumbers();
        Result result = getResult(lottoTicket,luckyNumbers);
        printResult(amount, result);


    }

    private LottoCount requestUserAmount(){
        int amount = InputView.requestUserAmount();
        try {
            return new LottoCount(amount);
        } catch(IllegalArgumentException e){
            OutputView.printException(e);
            throw new IllegalArgumentException();
        }
    }

    private LottoTicket buyTickets(LottoCount amount){
        int ticketCount = amount.calculateLottoCount();
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
            throw new IllegalArgumentException();
        }

    }

    private Result getResult(LottoTicket lottoTicket, LuckyNumbers luckyNumbers){
        return lottoTicket.calculateStatistic(luckyNumbers);
    }

    private void printResult(LottoCount amount, Result result){
        OutputView.printResult();
        OutputView.printLottoResult(result);
        OutputView.printProfit(result.calculateProfit(amount));
    }


}
