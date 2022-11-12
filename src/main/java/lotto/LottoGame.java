package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        LottoAmount amount = new LottoAmount(Input.purchaseAmount());
        Lottos lottos = purchaseLotto(amount.makeLottoTickets());
        BonusLotto bonusLotto = makeWinningLotto();
        Map<LottoOperator, Integer> winningResult = findWinningResult(lottos, bonusLotto);
        Print.winningResult(amount.makeLottoTickets(), winningResult);
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
        return new BonusLotto(winningLotto, Input.bonus());
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
