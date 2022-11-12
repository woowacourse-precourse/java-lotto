package lotto;

import java.util.LinkedHashMap;
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
        Print.winningResult(lottoTickets, winningResult);
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
        List<LottoOperator> winningRanks = lottos.result(bonusLotto);
        Map<LottoOperator, Integer> winningResult = resetWinningResult();
        for (LottoOperator rank : winningRanks) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

    private static Map<LottoOperator, Integer> resetWinningResult() {
        Map<LottoOperator, Integer> winningResult = new LinkedHashMap<>();
        winningResult.put(LottoOperator.NO_LUCK, 0);
        winningResult.put(LottoOperator.THREE, 0);
        winningResult.put(LottoOperator.FOUR, 0);
        winningResult.put(LottoOperator.FIVE, 0);
        winningResult.put(LottoOperator.FIVE_BONUS, 0);
        winningResult.put(LottoOperator.SIX, 0);
        return winningResult;
    }
}
