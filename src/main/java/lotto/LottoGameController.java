package lotto;

import java.util.List;

public class LottoGameController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        LottoAmount amount = inputMoney();
        LottoTickets lottoTickets = purchaseLotto(amount.makeLottoTickets());
        WinningLotto winningLotto = makeWinningLotto();
        LottoResult lottoResult = getResult(lottoTickets, winningLotto);
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

    private WinningLotto makeWinningLotto() {
        SystemMessage.winningNumber();
        List<Integer> winningNumber = Input.winningTicket();
        SystemMessage.bonusNumber();
        int bonus = Input.getNumber();
        return lottoGenerator.generateWinningTicket(winningNumber, bonus);
    }

    private LottoResult getResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return new LottoResult(lottoTickets.result(winningLotto));
    }
}
