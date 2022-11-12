package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Lottos lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);

        Print.winningNumber();
        Lotto winningLotto = generator.makeLotto(Input.winningNumber());
        Print.bonusNumber();
        int bonus = Input.bonus();

        BonusLotto bonusLotto = new BonusLotto(winningLotto, bonus);
        List<Integer> matchCount = lottos.result(bonusLotto);
        Map<LottoOperator, Integer> winningResult = findWinningResult(matchCount);
    }

    private Map<LottoOperator, Integer> findWinningResult(List<Integer> matchCount) {
        Map<LottoOperator, Integer> winningResult = new HashMap<>();
        for (Integer count : matchCount) {
            LottoOperator rank = LottoOperator.find(count);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        return winningResult;
    }
}
