package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Lottos lottos = purchaseLotto(lottoTickets);
        BonusLotto bonusLotto = makeWinningLotto();
        Map<LottoOperator, Integer> winningResult = findWinningResult(lottos, bonusLotto);
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }

    private BonusLotto makeWinningLotto() {
        Print.winningNumber();
        Lotto winningLotto = generator.makeLotto(Input.winningNumber());
        Print.bonusNumber();
        int bonus = Input.bonus();

        BonusLotto bonusLotto = new BonusLotto(winningLotto, bonus);
        return bonusLotto;
    }

    private Map<LottoOperator, Integer> findWinningResult(Lottos lottos, BonusLotto bonusLotto) {
        List<Integer> matchCount = lottos.result(bonusLotto);
        Map<LottoOperator, Integer> winningResult = new HashMap<>();
        for (Integer count : matchCount) {
            LottoOperator rank = LottoOperator.find(count);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return winningResult;
    }
}
