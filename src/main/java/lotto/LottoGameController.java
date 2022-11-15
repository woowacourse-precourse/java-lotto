package lotto;

import java.util.List;

public class LottoGameController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        LottoAmount amount = inputMoney();
        LottoTickets lottoTickets = purchaseLotto(amount.makeLottoTickets());
        WinningTicket winningTicket = makeWinningLotto();
        LottoResult lottoResult = getResult(lottoTickets, winningTicket);
        SystemMessage.winningResult(lottoResult.matchWinningRank());
        SystemMessage.profit(lottoResult.getProfit(amount.makeLottoTickets()));
    }

    private LottoAmount inputMoney() {
        SystemMessage.moneyInput();
        return new LottoAmount(Input.getNumber());
    }

    private LottoTickets purchaseLotto(int numberOfLottoTickets) {
        LottoTickets lottoTickets = lottoGenerator.generateLottoTickets(numberOfLottoTickets);
        SystemMessage.purchaseLotto(numberOfLottoTickets, lottoTickets);
        return lottoTickets;
    }

    private WinningTicket makeWinningLotto() {
        SystemMessage.winningNumber();
        List<Integer> winningNumber = Input.winningTicket();
        SystemMessage.bonusNumber();
        int bonus = Input.getNumber();
        return lottoGenerator.generateWinningTicket(winningNumber, bonus);
    }

    private LottoResult getResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        return new LottoResult(lottoTickets.getResult(winningTicket));
    }
}
