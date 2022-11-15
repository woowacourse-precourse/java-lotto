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
    }

    private LottoAmount inputMoney() {
        SystemMessage.moneyInput();
        return new LottoAmount(Input.getNumber());
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = lottoGenerator.makeLottos(lottoTickets);
        SystemMessage.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        SystemMessage.winningNumber();
        List<Integer> winningNumber = Input.winningNumber();
        SystemMessage.bonusNumber();
        int bonus = Input.getNumber();
        return lottoGenerator.makeLotto(winningNumber, bonus);
    }

    private LottoResult getResult(Lottos lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos.result(winningLotto));
    }
}
