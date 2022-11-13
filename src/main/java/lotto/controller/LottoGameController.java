package lotto.controller;


import lotto.domain.Ticket;
import lotto.service.LottoGameService;
import lotto.view.InputView;

public class LottoGameController {
    
    private InputView inputView;
    private LottoGameService lottoGameService;

    public void start() {
        int money = inputView.inputMoney();
        int ticketCnt = new Ticket().count(money);
        lottoGameService.pickLottos(ticketCnt);
    }


}
