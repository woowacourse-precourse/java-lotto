package lotto;

import java.util.List;

public class LottoGameController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        LottoAmount amount = inputMoney();
        Lottos lottos = purchaseLotto(amount.makeLottoTickets());
        WinningLotto winningLotto = makeWinningLotto();
        LottoResult lottoResult = getResult(lottos, winningLotto);
        SystemMessage.winningResult(lottoResult.matchWinningRank());
        SystemMessage.profit(lottoResult.getProfit(amount.makeLottoTickets()));
    }

    private LottoAmount inputMoney() {
        SystemMessage.moneyInput();
        return new LottoAmount(Input.getNumber());
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = lottoGenerator.generateLottoTickets(lottoTickets);
        SystemMessage.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        SystemMessage.winningNumber();
        List<Integer> winningNumber = Input.winningTicket();
        SystemMessage.bonusNumber();
        int bonus = Input.getNumber();
        return lottoGenerator.generateWinningTicket(winningNumber, bonus);
    }

    private LottoResult getResult(Lottos lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos.result(winningLotto));
    }
}
