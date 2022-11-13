package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoInput;
import lotto.model.LottoMachine;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.GameMessage;

public class GameController {
    private final GameMessage gameMessage = new GameMessage();
    private final LottoInput lottoInput = new LottoInput();
    private LottoMachine lottoMachine = new LottoMachine();
    private WinningLotto winningLotto;
    private User user;

    public void run() {
        publishUserLotto();
        assignWinningLotto();
    }

    public void publishUserLotto() {
        int purchaseAmount = inputPurchaseAmount();
        createUserLottoTicket(purchaseAmount);
        printUserLottoTicketDetail();
    }

    public void assignWinningLotto() {
        Lotto lotto = assignWinningNumber();
        int bonusNumber = assignBonusNumber();
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public int inputPurchaseAmount() {
        gameMessage.printInputPurchaseAmount();
        return lottoInput.inputPurchaseAmount();
    }

    public void createUserLottoTicket(int purchaseAmount) {
        int lottoTicketCount = lottoMachine.computeLottoTicketsCount(purchaseAmount);
        List<Lotto> lottoTickets = lottoMachine.publishLottoTickets(lottoTicketCount);
        user = new User(purchaseAmount, lottoTicketCount, lottoTickets);
    }

    public void printUserLottoTicketDetail() {
        gameMessage.printLottoTicketCount(user.getLottoTicketCount());
        gameMessage.printLottoTickets(user.getLottoTickets());
    }

    public Lotto assignWinningNumber() {
        gameMessage.printInputWinningNumber();
        List<Integer> winningNumber = lottoInput.inputWinningNumber();
        return new Lotto(winningNumber);
    }

    public int assignBonusNumber() {
        gameMessage.printInputBonusNumber();
        return lottoInput.inputBonusNumber();
    }
}
