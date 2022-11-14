package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoInput;
import lotto.service.LottoService;
import lotto.view.GameMessage;

public class LottoController {
    private final GameMessage gameMessage = new GameMessage();
    private final LottoInput lottoInput = new LottoInput();
    private final LottoService lottoService = new LottoService();

    public void run() {
        publishUserLotto();
        assignWinningLotto();
    }

    public void publishUserLotto() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.publishLottoTickets(purchaseAmount);
        printUserLottoTicketDetail(lottoTickets);
    }

    public int inputPurchaseAmount() {
        gameMessage.printInputPurchaseAmount();
        return lottoInput.inputPurchaseAmount();
    }

    public void printUserLottoTicketDetail(List<Lotto> lottoTickets) {
        gameMessage.printLottoTicketCount(lottoService.getLottoTicketCount());
        gameMessage.printLottoTickets(lottoTickets);
    }

    public void assignWinningLotto() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        lottoService.createWinningLotto(winningNumber, bonusNumber);
    }

    public List<Integer> inputWinningNumber() {
        gameMessage.printInputWinningNumber();
        return lottoInput.inputWinningNumber();
    }

    public int inputBonusNumber() {
        gameMessage.printInputBonusNumber();
        return lottoInput.inputBonusNumber();
    }

}
