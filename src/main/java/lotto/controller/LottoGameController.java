package lotto.controller;


import lotto.domain.Ticket;
import lotto.view.InputView;

public class LottoGameController {
    
    private InputView inputView;

    public void start() {
        int money = inputView.inputMoney();
        int ticketCnt = new Ticket().count(money);
    }


}
