package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.service.LottoGameService;
import lotto.view.InputView;

import java.util.List;

public class LottoGameController {
    
    private InputView inputView;
    private LottoGameService lottoGameService;

    public void start() {
        int money = inputView.inputMoney();
        int ticketCnt = new Ticket().count(money);
        List<Lotto> lottoList = lottoGameService.pickLottos(ticketCnt);
        Lotto winningNumbers = new Lotto(inputView.inputWinningNumbers());
        int bonusNumber = inputView.inputBonusNumber();
    }


}
