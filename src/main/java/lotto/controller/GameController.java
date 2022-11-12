package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoInput;
import lotto.model.LottoMachine;
import lotto.model.User;
import lotto.view.GameMessage;

public class GameController {
    private final GameMessage gameMessage = new GameMessage();
    private final LottoInput lottoInput = new LottoInput();
    private LottoMachine lottoMachine = new LottoMachine();
    private User user;

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        publishUserLotto(purchaseAmount);
        printLottoTicketDetail();
    }

    public int inputPurchaseAmount() {
        gameMessage.printInputPurchaseAmount();
        return lottoInput.inputPurchaseAmount();
    }

    public void publishUserLotto(int purchaseAmount) {
        int lottoTicketCount = lottoMachine.computeLottoTicketsCount(purchaseAmount);
        List<Lotto> lottoTickets = lottoMachine.publishLottoTickets(lottoTicketCount);
        user = new User(purchaseAmount, lottoTicketCount, lottoTickets);
    }

    public void printLottoTicketDetail() {
        gameMessage.printLottoTicketCount(user.getLottoTicketCount());
    }


}
