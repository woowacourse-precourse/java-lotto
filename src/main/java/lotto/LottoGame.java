package lotto;

import java.util.List;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        LottoAmount amount = insertMoney();
        Lottos lottos = purchaseLotto(amount.makeLottoTickets());
        WinningLotto winningLotto = makeWinningLotto();
        LottoResult result = makeResult(lottos, winningLotto);
        Print.winningResult(result.matchWinningRank());
        Print.yield(result.makeYield(amount.makeLottoTickets()));
    }

    private LottoAmount insertMoney() {
        Print.money();
        return new LottoAmount(Input.number());
    }

    private LottoResult makeResult(Lottos lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos.result(winningLotto));
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        Print.winningNumber();
        List<Integer> winningNumber = Input.winningNumber();
        Print.bonusNumber();
        int bonus = Input.number();
        return generator.makeLotto(winningNumber, bonus);
    }
}
